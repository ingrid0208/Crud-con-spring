package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;


import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.DTO.SeguroDto;
import com.sena.crud_basic.Interfaces.ISeguro;

import com.sena.crud_basic.model.Seguro;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SeguroService {

    @Autowired
    private ISeguro seguroData;

     public List<SeguroDto> findAll(){
        try{
            var seguro = seguroData.findAll();
            return MapToList(seguro);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public SeguroDto findById(int id){
        try{
            var seguro = seguroData.findById(id);

            if (!seguro.isPresent()) {
                throw new EntityNotFoundException("cliente no encontro el id: " + id);
            }

            return MapToDto(seguro.get());

        }catch (EntityNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public ResponseDto save(SeguroDto seguroDto){
        if (seguroData.findById(seguroDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "El id ya existe");
        }
        try{
            seguroData.save(MapToEntity(seguroDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(SeguroDto SeguroDto){
        try{
            if (SeguroDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST, "ID valido");
            }

            var existing = seguroData.findById(SeguroDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND,"no se encontro el id");
            }

            var updatedauthor = MapToEntity (SeguroDto);
            seguroData.save(updatedauthor);
            return createResponse(HttpStatus.OK, "actualiza exitosa");
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar: "+ e.getMessage());
        }
        
    }

    public ResponseDto delete(int id){
        try{
            var Seguro = seguroData.findById(id);
            if(Seguro.isPresent()){
                seguroData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

    public Seguro MapToEntity(SeguroDto SeguroDto){


        return new Seguro(
            SeguroDto.getId(),
            SeguroDto.getProveedor(),
            SeguroDto.getTipo_Seguro(),
            SeguroDto.getCobertura(), 
            SeguroDto.getVigencia());
    }

    public SeguroDto MapToDto(Seguro entity){
        return new SeguroDto(
            entity.getId(),
            entity.getProveedor(),
            entity.getTipo_Seguro(),
            entity.getCobertura(),
            entity.getVigencia()
            
            
        );
    }


    public List<SeguroDto> MapToList(List<Seguro> entities){
        List<SeguroDto> dtos = new ArrayList<>();
        for (Seguro entity : entities) {
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
