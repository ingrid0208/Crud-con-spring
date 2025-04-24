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
import com.sena.crud_basic.DTO.SeguroDto;

import com.sena.crud_basic.Service.SeguroService;

@RestController
@RequestMapping("api/v1/Seguro")
public class SeguroController {

    @Autowired
    private SeguroService SeguroService;

    @GetMapping
    public ResponseEntity<Object> findAllSeguro(){
        var ListSeguro = SeguroService.findAll();
        return new ResponseEntity<Object>(ListSeguro,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findSeguroById(@PathVariable int id){
        var Seguro = SeguroService.findById(id);
        return new ResponseEntity<>(Seguro,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveSeguro(@RequestBody SeguroDto SeguroDto){
    ResponseDto response = SeguroService.save(SeguroDto);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
     public ResponseEntity<ResponseDto> putMethodName(@RequestBody SeguroDto Seguro){
    ResponseDto response = SeguroService.update(Seguro);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteSeguro(@PathVariable int id){
    ResponseDto response = SeguroService.delete(id);
    return new ResponseEntity<>(response, response.getStatus());
    }
}
