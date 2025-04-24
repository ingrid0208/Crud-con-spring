package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;


import com.sena.crud_basic.DTO.ExcursionDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Interfaces.IExcursion;

import com.sena.crud_basic.model.Excursion;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ExcursionService {

    @Autowired
    private IExcursion ExcursionData;

    public List<ExcursionDto> findAll(){
       try{
        var excursion = ExcursionData.findAll();
        return MapToList(excursion);
       }catch(Exception e){
        throw new RuntimeException("error al traer los datos de la excursion" + e);
       }
    }

    public ExcursionDto findById(int id){
       try{
        var excursion = ExcursionData.findById(id);

        if (!excursion.isPresent()){
            throw new EntityNotFoundException("Excursion no encontro el id" + id);
        }

        return MapToDto(excursion.get());

       }catch (EntityNotFoundException e){
        throw e;
       }catch(Exception e){
        throw new RuntimeException("error al traer los datos de la excursion" + e);
       }
    }
    
    public ResponseDto save(ExcursionDto excursionDto){
        if (ExcursionData.findById(excursionDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "ya existe un id");
        }
        try{
            ExcursionData.save(MapToEntity(excursionDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(ExcursionDto excursionDto){
     try{
        if(excursionDto.getId()<= 0){
            return createResponse(HttpStatus.BAD_REQUEST, "id invalido");
        }

        var existing = ExcursionData.findById(excursionDto.getId());
        if (!existing.isPresent()){
            return createResponse(HttpStatus.NOT_FOUND, "no existe el id");
        }

        var updatedauthor = MapToEntity (excursionDto);
        ExcursionData.save(updatedauthor);
        return createResponse(HttpStatus.OK, "se actualizo correctamente");
            
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar "+ e.getMessage());
        }
    }

    public ResponseDto delete(int id){
        try{
            var Excursion = ExcursionData.findById(id);
            if(Excursion.isPresent()){
                ExcursionData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

       public Excursion MapToEntity(ExcursionDto ExcursionDto){


        return new Excursion(
            ExcursionDto.getId(),
            ExcursionDto.getNombre(),
            ExcursionDto.getDescription(),
            ExcursionDto.getDuracion(),
            ExcursionDto.getActividad_incluidas());
    }

    public ExcursionDto MapToDto(Excursion entity){
        return new ExcursionDto(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getDuracion(),
            entity.getActividades_Incluidas()

            
        );
    }

    public List<ExcursionDto> MapToList(List<Excursion> entities){
        List<ExcursionDto> dtos = new ArrayList<>();
        for (Excursion entity : entities) {
            dtos.add(MapToDto(entity));
    }
    return dtos;
}

// Response
public ResponseDto createResponse(HttpStatus status, String message) {
    ResponseDto response = new ResponseDto();
    response.setStatus(status);
    response.setMessage(message);
    return response;
}


}
