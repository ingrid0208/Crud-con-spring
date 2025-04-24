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
import com.sena.crud_basic.DTO.VueloDto;

import com.sena.crud_basic.Service.VueloService;

@RestController
@RequestMapping("api/v1/Vuelo")
public class VueloController {

    @Autowired
    private VueloService VueloService;

    @GetMapping
    public ResponseEntity<Object> findAllVuelo(){
        var ListVuelo = VueloService.findAll();
        return new ResponseEntity<Object>(ListVuelo,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findVueloById(@PathVariable int id){
        var Vuelo = VueloService.findById(id);
        return new ResponseEntity<>(Vuelo,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveVuelo(@RequestBody VueloDto VueloDto){
    ResponseDto response = VueloService.save(VueloDto);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
     public ResponseEntity<ResponseDto> putMethodName(@RequestBody VueloDto Vuelo){
    ResponseDto response = VueloService.update(Vuelo);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteVuelo(@PathVariable int id){
    ResponseDto response = VueloService.delete(id);
    return new ResponseEntity<>(response, response.getStatus());
    }
}
