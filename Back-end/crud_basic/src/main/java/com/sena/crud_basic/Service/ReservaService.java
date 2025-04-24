package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;


import com.sena.crud_basic.DTO.ReservaDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Interfaces.IReserva;
import com.sena.crud_basic.model.Cliente;
import com.sena.crud_basic.model.Paquete;
import com.sena.crud_basic.model.Reserva;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaService {

    @Autowired
    private IReserva ReservaData;

   public List<ReservaDto> findAll(){
        try{
            var Reserva = ReservaData.findAll();
            return MapToList(Reserva);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de Reserva"+ e);
        }
    }

    public ReservaDto findById(int id){
        try{
            var Reserva = ReservaData.findById(id);

            if (!Reserva.isPresent()) {
                throw new EntityNotFoundException("cliente no encontro el id: " + id);
            }

            return MapToDto(Reserva.get());

        }catch (EntityNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de Reserva"+ e);
        }
    }

    public ResponseDto save(ReservaDto ReservaDto){
        if (ReservaData.findById(ReservaDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "El id ya existe");
        }
        try{
            ReservaData.save(MapToEntity(ReservaDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(ReservaDto ReservaDto){
        try{
            if (ReservaDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST, "ID valido");
            }

            var existing = ReservaData.findById(ReservaDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND,"no se encontro el id");
            }

            var updatedauthor = MapToEntity (ReservaDto);
            ReservaData.save(updatedauthor);
            return createResponse(HttpStatus.OK, "actualiza exitosa");
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar: "+ e.getMessage());
        }
        
    }

    public ResponseDto delete(int id){
        try{
            var Reserva = ReservaData.findById(id);
            if(Reserva.isPresent()){
                ReservaData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

    public Reserva MapToEntity(ReservaDto ReservaDto){

        Cliente cliente = new Cliente ();
        cliente.setId(ReservaDto.getId_cliente());

        Paquete paquete = new Paquete ();
        paquete.setId(ReservaDto.getId_Paquete());

        return new Reserva(
            ReservaDto.getId(),
            ReservaDto.getFechaReserva(),
            ReservaDto.getEstado(),
            cliente, 
            paquete);
    }

    public ReservaDto MapToDto(Reserva entity){
        return new ReservaDto(
            entity.getId(),
            entity.getFechaReserva(),
            entity.getEstado(),
            entity.getCliente().getId(),
            entity.getPaquete().getId()
           
        );
    }


    public List<ReservaDto> MapToList(List<Reserva> entities){
        List<ReservaDto> dtos = new ArrayList<>();
        for (Reserva entity : entities) {
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


