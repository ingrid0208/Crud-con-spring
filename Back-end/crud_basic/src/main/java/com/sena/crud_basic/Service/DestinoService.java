package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.DestinoDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Interfaces.IDestino;
import com.sena.crud_basic.model.destino;

import jakarta.persistence.EntityNotFoundException;

@Service

public class DestinoService {

    @Autowired
    private IDestino DestinoData;

    public List<DestinoDto> findAll() {
        try{
            var destino = DestinoData.findAll();
            return MapToList(destino);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de destino"+ e);
        }
    }

    public DestinoDto findById(int id){
       try{
        var destino = DestinoData.findById(id);

        if (!destino.isPresent()){
            throw new EntityNotFoundException("cliente no encontro el id: "+ id);
        }

        return MapToDto(destino.get());
       }catch(EntityNotFoundException e){
        throw e;

       }catch(Exception e){
        throw new RuntimeException("Error al traer los datos del destino"+ e);
       }
    }
    
    public ResponseDto save(DestinoDto destinoDto){
       if(DestinoData.findById(destinoDto.getId()).isPresent()){
        return new ResponseDto(HttpStatus.BAD_REQUEST, "el id ya esxiste");
       }
       try{
        DestinoData.save(MapToEntity(destinoDto));
        return createResponse(HttpStatus.CREATED, "se creo correctamente");
       }catch(Exception e){
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el destino"+ e.getMessage());
       }
    }


    public ResponseDto update(DestinoDto destinoDto){
        try{
            if(destinoDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST,"Id valido");
            }

            var existing = DestinoData.findById(destinoDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND, "No existe el destino con el id: ");
        }

        var updatedauthor = MapToEntity(destinoDto);
        DestinoData.save(updatedauthor);
        return createResponse(HttpStatus.OK, "se actualizo correctamente");
    }catch (Exception e){
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar el destino"+ e.getMessage());
    }
}

    public ResponseDto delete(int id){
        try{
            var destino = DestinoData.findById(id);
            if (destino.isPresent()){
                DestinoData.deleteById(id);
                return createResponse(HttpStatus.OK, "se elimino correctamente");
        }else{
            return createResponse(HttpStatus.NOT_FOUND, "No existe el destino con el id: ");
        }
    }catch (Exception e){
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el destino"+ e.getMessage());
    }
}

    public destino MapToEntity(DestinoDto destinoDto){
       
        return new destino(
            destinoDto.getId(),
            destinoDto.getNombre(),
            destinoDto.getCuidad(),
            destinoDto.getPais(),
            destinoDto.getDescripcion());

    }

    public DestinoDto MapToDto(destino entity){
        return new DestinoDto(
            entity.getId(),
            entity.getNombre(),
            entity.getCiudad(),
            entity.getPais(),
            entity.getDescripcion());

    }

    public List<DestinoDto>MapToList(List<destino> entities){
        List<DestinoDto> dtos = new ArrayList<>();
        for (destino entity : entities) {
            dtos.add(MapToDto(entity));
    }
    return dtos;
}

public ResponseDto createResponse(HttpStatus status, String message){
    ResponseDto response = new ResponseDto();
    response.setStatus(status);
    response.setMessage(message);
    return response;
}



}
