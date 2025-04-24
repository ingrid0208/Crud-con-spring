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


import com.sena.crud_basic.DTO.ItinerarioDto;
import com.sena.crud_basic.DTO.ResponseDto;

import com.sena.crud_basic.Service.ItinerarioService;

@RestController
@RequestMapping("api/v1/Itinerario")
public class ItinerarioController {

    @Autowired
    private ItinerarioService itinerarioService;

    @GetMapping
    public ResponseEntity<Object> findAllItinerario(){
        var ListItinerario = itinerarioService.findAll();
        return new ResponseEntity<Object>(ListItinerario,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findItinerarioeById(@PathVariable int id){
        var Itinerario = itinerarioService.findById(id);
        return new ResponseEntity<>(Itinerario,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveItinerario(@RequestBody ItinerarioDto itinerarioDto){
    ResponseDto response = itinerarioService.save(itinerarioDto);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
     public ResponseEntity<ResponseDto> putMethodName(@RequestBody ItinerarioDto itinerario){
    ResponseDto response = itinerarioService.update(itinerario);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteItinerario(@PathVariable int id){
    ResponseDto response = itinerarioService.delete(id);
    return new ResponseEntity<>(response, response.getStatus());
    }
    
}
