package com.sena.crud_basic.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.DTO.TransporteDto;

import com.sena.crud_basic.Service.TransporteService;

@RestController
@RequestMapping("api/v1/Transporte")
public class TransporteController {

    @Autowired
    private TransporteService transporteService;

    @GetMapping
    public ResponseEntity<Object> findAllTransporte(){
        var ListTransporte = transporteService.findAll();
        return new ResponseEntity<Object>(ListTransporte,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findTransporteById(@PathVariable int id){
        var Transporte = transporteService.findById(id);
        return new ResponseEntity<>(Transporte,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveTransporte(@RequestBody TransporteDto transporteDto){
    ResponseDto response = transporteService.save(transporteDto);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
     public ResponseEntity<ResponseDto> putMethodName(@RequestBody TransporteDto transporte){
    ResponseDto response = transporteService.update(transporte);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteTransporte(@PathVariable int id){
    ResponseDto response = transporteService.delete(id);
    return new ResponseEntity<>(response, response.getStatus());
    }
   
}
