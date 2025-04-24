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


import com.sena.crud_basic.DTO.ReservaDto;
import com.sena.crud_basic.DTO.ResponseDto;

import com.sena.crud_basic.Service.ReservaService;

@RestController
@RequestMapping("api/v1/Reserva")
public class ReservaController {

    @Autowired
    private ReservaService ReservaService;

    @GetMapping
    public ResponseEntity<Object> findAllReserva(){
        var ListReserva = ReservaService.findAll();
        return new ResponseEntity<Object>(ListReserva,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findReservaById(@PathVariable int id){
        var Reserva = ReservaService.findById(id);
        return new ResponseEntity<>(Reserva,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveReserva(@RequestBody ReservaDto ReservaDto){
    ResponseDto response = ReservaService.save(ReservaDto);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
     public ResponseEntity<ResponseDto> putMethodName(@RequestBody ReservaDto Reserva){
    ResponseDto response = ReservaService.update(Reserva);
    return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteReserva(@PathVariable int id){
    ResponseDto response = ReservaService.delete(id);
    return new ResponseEntity<>(response, response.getStatus());
    }
}
