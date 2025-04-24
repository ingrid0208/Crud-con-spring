package com.sena.crud_basic.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sena.crud_basic.DTO.ExcursionDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Service.ExcursionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/Excursion")
public class ExcursionController {

    @Autowired
    private ExcursionService excursionService;

    @GetMapping
    public ResponseEntity<Object> findAllDestino(){
        var ListDestino = excursionService.findAll();
        return new ResponseEntity<Object>(ListDestino,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findExcursionById(@PathVariable int id){
        var Excursion = excursionService.findById(id);
        return new ResponseEntity<>(Excursion,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveExcursion(@RequestBody ExcursionDto excursionDto){
        ResponseDto response = excursionService.save(excursionDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDto> putMethodName(@RequestBody ExcursionDto excursion){
        ResponseDto response = excursionService.update(excursion);
        return new ResponseEntity<>(response, response.getStatus());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteExcursion(@PathVariable int id){
    ResponseDto response = excursionService.delete(id);
    return new ResponseEntity<>(response, response.getStatus());
    }

    }
    
    

