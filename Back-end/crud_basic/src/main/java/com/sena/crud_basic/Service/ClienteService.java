package com.sena.crud_basic.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.ClienteDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Interfaces.ICliente;
import com.sena.crud_basic.model.Cliente;


import jakarta.persistence.EntityNotFoundException;
@Service

public class ClienteService {
    /*
     * @Autowired = incluye la conexion de la interfaz
     */

    @Autowired
    private ICliente ClienteData;

    public List<ClienteDto> findAll(){
        try{
            var cliente = ClienteData.findAll();
            return MapToList(cliente);
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public ClienteDto findById(int id){
        try{
            var cliente = ClienteData.findById(id);

            if (!cliente.isPresent()) {
                throw new EntityNotFoundException("cliente no encontro el id: " + id);
            }

            return MapToDto(cliente.get());

        }catch (EntityNotFoundException e){
            throw e;
        }catch(Exception e){
            throw new RuntimeException("Error al traer los datos de cliente"+ e);
        }
    }

    public ResponseDto save(ClienteDto clienteDto){
        if (ClienteData.findById(clienteDto.getId()).isPresent()){
            return new ResponseDto(HttpStatus.BAD_REQUEST, "El id ya existe");
        }
        try{
            ClienteData.save(MapToEntity(clienteDto));
            return createResponse(HttpStatus.CREATED, "se creo correctamente");
        }catch(Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al crear "+ e.getMessage());
        }
    }

    public ResponseDto update(ClienteDto clienteDto){
        try{
            if (clienteDto.getId()<= 0){
                return createResponse(HttpStatus.BAD_REQUEST, "ID valido");
            }

            var existing = ClienteData.findById(clienteDto.getId());
            if (!existing.isPresent()){
                return createResponse(HttpStatus.NOT_FOUND,"no se encontro el id");
            }

            var updatedauthor = MapToEntity (clienteDto);
            ClienteData.save(updatedauthor);
            return createResponse(HttpStatus.OK, "actualiza exitosa");
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error al actualizar: "+ e.getMessage());
        }
        
    }

    public ResponseDto delete(int id){
        try{
            var Cliente = ClienteData.findById(id);
            if(Cliente.isPresent()){
                ClienteData.deleteById(id);
                return createResponse(HttpStatus.OK, "se borro correctamente");
            }else{
                return createResponse(HttpStatus.NOT_FOUND, "No se encontró el ID");
            }
        }catch (Exception e){
            return createResponse(HttpStatus.INTERNAL_SERVER_ERROR,  "Error al eliminar: " + e.getMessage());
        }
    }

    public Cliente MapToEntity(ClienteDto ClienteDto){

        return new Cliente(
            ClienteDto.getId(),
            ClienteDto.getName(),
            ClienteDto.getApellido(),
            ClienteDto.getDireccion(),
            ClienteDto.getTelefono(),
            ClienteDto.getEmail());
    }

    public ClienteDto MapToDto(Cliente entity){
        return new ClienteDto(
            entity.getId(),
            entity.getName(),
            entity.getApellido(),
            entity.getDireccion(),
            entity.getTelefono(),
            entity.getEmail()
            
        );
    }


    public List<ClienteDto> MapToList(List<Cliente> entities){
        List<ClienteDto> dtos = new ArrayList<>();
        for (Cliente entity : entities) {
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
