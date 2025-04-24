package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;


import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.DTO.TransporteDto;
import com.sena.crud_basic.Interfaces.ITransporte;

import com.sena.crud_basic.model.Transporte;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TransporteService {

    @Autowired
    private ITransporte TransporteData;

    public List<TransporteDto> findAll(){
        try{
            var Transporte = TransporteData.findAll();
            return MapToList(Transporte);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de Transporte"+ e);
        }
    }

    public TransporteDto findById(int id){
        try{
            var Transporte = TransporteData.findById(id);

            if (!Transporte.isPresent()) {
                throw new EntityNotFoundException("cliente no encontro el id: " + id);
            }

            return MapToDto(Transporte.get());

        }catch (EntityNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public ResponseDto save(TransporteDto TransporteDto){
        if (TransporteData.findById(TransporteDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "El id ya existe");
        }
        try{
            TransporteData.save(MapToEntity(TransporteDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(TransporteDto TransporteDto){
        try{
            if (TransporteDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST, "ID valido");
            }

            var existing = TransporteData.findById(TransporteDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND,"no se encontro el id");
            }

            var updatedauthor = MapToEntity (TransporteDto);
            TransporteData.save(updatedauthor);
            return createResponse(HttpStatus.OK, "actualiza exitosa");
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar: "+ e.getMessage());
        }
        
    }

    public ResponseDto delete(int id){
        try{
            var Transporte = TransporteData.findById(id);
            if(Transporte.isPresent()){
                TransporteData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

    public Transporte MapToEntity(TransporteDto TransporteDto){


        return new Transporte(
            TransporteDto.getId(),
            TransporteDto.getTipo(),
            TransporteDto.getEmpresa(),
            TransporteDto.getHorario_Salida(),
            TransporteDto.getHorario_llegada());
    }

    public TransporteDto MapToDto(Transporte entity){
        return new TransporteDto(
            entity.getId(),
            entity.getTipo(),
            entity.getEmpresa(),
            entity.getHorario_Salida(),
            entity.getHorario_llegada()
            
            
        );
    }


    public List<TransporteDto> MapToList(List<Transporte> entities){
        List<TransporteDto> dtos = new ArrayList<>();
        for (Transporte entity : entities) {
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