package com.sena.crud_basic.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.DTO.DestinoDto;
import com.sena.crud_basic.DTO.ResponseDto;
import com.sena.crud_basic.Service.DestinoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/Destino")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public ResponseEntity<Object> findAllDestino(){
        var ListDestino = destinoService.findAll();
        return new ResponseEntity<Object>(ListDestino,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findDestinoById(@PathVariable int id) {
        var destino = destinoService.findById(id);
        return new ResponseEntity<>(destino, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveDestino(@RequestBody DestinoDto destinoDto) {
        ResponseDto response = destinoService.save(destinoDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDto> putMethodName (@RequestBody DestinoDto destino) {
        ResponseDto response = destinoService.update(destino);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteDestino(@PathVariable int id) {
        ResponseDto response = destinoService.delete(id);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
