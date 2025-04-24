package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;


import com.sena.crud_basic.DTO.HotelDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Interfaces.IHotel;

import com.sena.crud_basic.model.Hotel;

import jakarta.persistence.EntityNotFoundException;

@Service

public class HotelService {

    @Autowired
    private IHotel HotelData;

    public List<HotelDto> findAll(){
        try{
            var hotel = HotelData.findAll();
            return MapToList(hotel);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de hotel"+ e);
        }
    }

    public HotelDto findById(int id){
        try{
            var hotel = HotelData.findById(id);

            if (!hotel.isPresent()) {
                throw new EntityNotFoundException("hotel no encontro el id: " + id);
            }

            return MapToDto(hotel.get());

        }catch (EntityNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de hotel"+ e);
        }
    }

    public ResponseDto save(HotelDto hotelDto){
       if (HotelData.findById(hotelDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "El id ya existe");
        }
        try{
            HotelData.save(MapToEntity(hotelDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(HotelDto hotelDto){
        try{
            if (hotelDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST, "ID valido");
            }

            var existing = HotelData.findById(hotelDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND,"no se encontro el id");
            }

            var updatedauthor = MapToEntity (hotelDto);
            HotelData.save(updatedauthor);
            return createResponse(HttpStatus.OK, "actualiza exitosa");
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar: "+ e.getMessage());
        }
        
    }
    

    public ResponseDto delete(int id){
        try{
            var Hotel = HotelData.findById(id);
            if(Hotel.isPresent()){
                HotelData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

    public  Hotel MapToEntity(HotelDto hotelDto){


        return new Hotel(
            hotelDto.getId(),
            hotelDto.getNombre(),
            hotelDto.getDireccion(),
            hotelDto.getNumero_Estrella(),
            hotelDto.getTelefono());
    }

    public HotelDto MapToDto(Hotel entity){
        return new HotelDto(
            entity.getId(),
            entity.getNombre(),
            entity.getDirreccion(),
            entity.getNumero_Estrellas(),
            entity.getTelefono()
           
            
        );
    }

    public List<HotelDto> MapToList(List<Hotel> entities){
        List<HotelDto> dtos = new ArrayList<>();
        for (Hotel entity : entities) {
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
