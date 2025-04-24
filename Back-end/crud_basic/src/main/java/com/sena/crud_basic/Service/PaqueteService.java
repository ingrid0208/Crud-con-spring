package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sena.crud_basic.DTO.PaqueteDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Interfaces.IPaquete;

import com.sena.crud_basic.model.Excursion;
import com.sena.crud_basic.model.Hotel;
import com.sena.crud_basic.model.Itinerario;
import com.sena.crud_basic.model.Paquete;

import com.sena.crud_basic.model.Seguro;
import com.sena.crud_basic.model.Transporte;
import com.sena.crud_basic.model.Vuelo;
import com.sena.crud_basic.model.destino;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("api/v1/Paquete")
public class PaqueteService {

    @Autowired
    private IPaquete PaqueteData;

    public List<PaqueteDto> findAll(){
        try{
            var paquete = PaqueteData.findAll();
            return MapToList(paquete);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public PaqueteDto findById(int id){
        try{
            var Paquete = PaqueteData.findById(id);

            if (!Paquete.isPresent()) {
                throw new EntityNotFoundException("cliente no encontro el id: " + id);
            }

            return MapToDto(Paquete.get());

        }catch (EntityNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public ResponseDto save(PaqueteDto PaqueteDto){
        if (PaqueteData.findById(PaqueteDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "El id ya existe");
        }
        try{
            PaqueteData.save(MapToEntity(PaqueteDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(PaqueteDto PaqueteDto){
        try{
            if (PaqueteDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST, "ID valido");
            }

            var existing = PaqueteData.findById(PaqueteDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND,"no se encontro el id");
            }

            var updatedauthor = MapToEntity (PaqueteDto);
            PaqueteData.save(updatedauthor);
            return createResponse(HttpStatus.OK, "actualiza exitosa");
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar: "+ e.getMessage());
        }
        
    }

    public ResponseDto delete(int id){
        try{
            var Paquete = PaqueteData.findById(id);
            if(Paquete.isPresent()){
                PaqueteData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

    public Paquete MapToEntity(PaqueteDto PaqueteDto){

      
        destino destino = new destino();
        destino.setId(PaqueteDto.getId_destino());

        Vuelo vuelo = new Vuelo();
        vuelo.setId(PaqueteDto.getId_vuelo());

        Hotel hotel = new Hotel();
        hotel.setId(PaqueteDto.getId_hotel());

        Excursion excursion = new Excursion();
        excursion.setId(PaqueteDto.getId_excursion());

        Transporte transporte = new Transporte();
        transporte.setId(PaqueteDto.getId_transporte());

        Seguro seguro = new Seguro();
        seguro.setId(PaqueteDto.getId_seguro());

        Itinerario itinerario = new Itinerario();
        itinerario.setId(PaqueteDto.getId_itinerario());

        return new Paquete(
            PaqueteDto.getId(),
            PaqueteDto.getNombre(),
            PaqueteDto.getDescripcion(),
            PaqueteDto.getPrecio(),
            null,
            destino,
            vuelo,
            hotel,
            excursion,
            transporte,
            seguro,
            itinerario

            );
    }

    public PaqueteDto MapToDto(Paquete entity){
        return new PaqueteDto(
            entity.getId(),
            entity.getNombre(),
            entity.getDescricion(),
            entity.getPrecio(),
            entity.getDestino().getId(),
            entity.getVuelo().getId(),
            entity.getHotel().getId(),
            entity.getExcursion().getId(),
            entity.getTransporte().getId(),
            entity.getSeguro().getId(),
            entity.getItinerario().getId()
            
        );
    }


    public List<PaqueteDto> MapToList(List<Paquete> entities){
        List<PaqueteDto> dtos = new ArrayList<>();
        for (Paquete entity : entities) {
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


