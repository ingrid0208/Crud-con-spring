package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;


import com.sena.crud_basic.DTO.ItinerarioDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Interfaces.IItinerario;

import com.sena.crud_basic.model.Itinerario;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItinerarioService {

    @Autowired
    private IItinerario ItinerarioData;

    public List<ItinerarioDto> findAll(){
         try{
            var itinerario = ItinerarioData.findAll();
            return MapToList(itinerario);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }
    
    public ItinerarioDto findById(int id){
        try{
            var itinerario = ItinerarioData.findById(id);

            if (!itinerario.isPresent()) {
                throw new EntityNotFoundException("Itinerario no encontro el id: " + id);
            }

            return MapToDto(itinerario.get());

        }catch (EntityNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de Itinerario"+ e);
        }
    }

   public ResponseDto save(ItinerarioDto itinerarioDto){
        if (ItinerarioData.findById(itinerarioDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "El id ya existe");
        }
        try{
            ItinerarioData.save(MapToEntity(itinerarioDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(ItinerarioDto itinerarioDto){
        try{
            if (itinerarioDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST, "ID valido");
            }

            var existing = ItinerarioData.findById(itinerarioDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND,"no se encontro el id");
            }

            var updatedauthor = MapToEntity (itinerarioDto);
            ItinerarioData.save(updatedauthor);
            return createResponse(HttpStatus.OK, "actualiza exitosa");
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar: "+ e.getMessage());
        }
        
    }

    public ResponseDto delete(int id){
        try{
            var Itinerario = ItinerarioData.findById(id);
            if(Itinerario.isPresent()){
                ItinerarioData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

    public Itinerario MapToEntity(ItinerarioDto itinerarioDto){


        return new Itinerario(
            itinerarioDto.getId(),
            itinerarioDto.getDescripcion_Dias(),
            itinerarioDto.getActividades_Programadas());
    }

    public ItinerarioDto MapToDto(Itinerario entity){
        return new ItinerarioDto(
            entity.getId(),
            entity.getDescription_Dias(),
            entity.getActividades_Programadas()
           
            
        );
    }

    public List<ItinerarioDto> MapToList(List<Itinerario> entities){
        List<ItinerarioDto> dtos = new ArrayList<>();
        for (Itinerario entity : entities) {
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
