package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;


import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.DTO.VueloDto;
import com.sena.crud_basic.Interfaces.IVuelo;

import com.sena.crud_basic.model.Vuelo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VueloService {
    @Autowired
    private IVuelo VueloData;

    public List<VueloDto> findAll(){
        try{
            var Vuelo = VueloData.findAll();
            return MapToList(Vuelo);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public VueloDto findById(int id){
        try{
            var Vuelo = VueloData.findById(id);

            if (!Vuelo.isPresent()) {
                throw new EntityNotFoundException("cliente no encontro el id: " + id);
            }

            return MapToDto(Vuelo.get());

        }catch (EntityNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public ResponseDto save(VueloDto VueloDto){
        if (VueloData.findById(VueloDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "El id ya existe");
        }
        try{
            VueloData.save(MapToEntity(VueloDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(VueloDto VueloDto){
        try{
            if (VueloDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST, "ID valido");
            }

            var existing = VueloData.findById(VueloDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND,"no se encontro el id");
            }

            var updatedauthor = MapToEntity (VueloDto);
            VueloData.save(updatedauthor);
            return createResponse(HttpStatus.OK, "actualiza exitosa");
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar: "+ e.getMessage());
        }
        
    }

    public ResponseDto delete(int id){
        try{
            var Vuelo = VueloData.findById(id);
            if(Vuelo.isPresent()){
                VueloData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

    public Vuelo MapToEntity(VueloDto VueloDto){


        return new Vuelo(
            VueloDto.getId(),
            VueloDto.getAerolinea(),
            VueloDto.getNumero_Vuelo(),
            VueloDto.getAeropuerto_Origen(), 
            VueloDto.getAeropuerto_Destino(),
            VueloDto.getFecha_Hora_Salida(), 
            VueloDto.getFecha_Hora_Llegada());
    }

    public VueloDto MapToDto(Vuelo entity){
        return new VueloDto(
            entity.getId(),
            entity.getAerolinea(),
            entity.getNumeroVuelo(),
            entity.getAeropuerto_Origen(),
            entity.getAeropuerto_Destino(),
            entity.getFecha_Hora_Salida(),
            entity.getFecha_Hora_llegada()
            
        );
    }


    public List<VueloDto> MapToList(List<Vuelo> entities){
        List<VueloDto> dtos = new ArrayList<>();
        for (Vuelo entity : entities) {
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

