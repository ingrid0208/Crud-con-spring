package com.sena.crud_basic.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import com.sena.crud_basic.DTO.ClienteDto;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Object> findAllCliente(){
        var ListCliente = clienteService.findAll();
        return new ResponseEntity<Object>(ListCliente,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findClienteById(@PathVariable int id){
        var cliente = clienteService.findById(id);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveCliente(@RequestBody ClienteDto clienteDto){
    ResponseDto response = clienteService.save(clienteDto);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
     public ResponseEntity<ResponseDto> putMethodName(@RequestBody ClienteDto cliente){
    ResponseDto response = clienteService.update(cliente);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCliente(@PathVariable int id){
    ResponseDto response = clienteService.delete(id);
    return new ResponseEntity<>(response, response.getStatus());
    }
    
    
}
