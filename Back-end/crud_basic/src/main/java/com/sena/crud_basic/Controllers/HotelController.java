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


import com.sena.crud_basic.DTO.HotelDto;
import com.sena.crud_basic.DTO.ResponseDto;

import com.sena.crud_basic.Service.HotelService;

@RestController
@RequestMapping("api/v1/Hotel")
public class HotelController {

    @Autowired
    private HotelService HotelService;

    @GetMapping
    public ResponseEntity<Object> findAllHotel(){
        var ListHotel = HotelService.findAll();
        return new ResponseEntity<Object>(ListHotel,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findHotelById(@PathVariable int id){
        var Hotel = HotelService.findById(id);
        return new ResponseEntity<>(Hotel,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveHotel(@RequestBody HotelDto HotelDto){
        ResponseDto response = HotelService.save(HotelDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDto> putMethodName(@RequestBody HotelDto Hotel){
        ResponseDto response = HotelService.update(Hotel);
        return new ResponseEntity<>(response, response.getStatus());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteExcursion(@PathVariable int id){
    ResponseDto response = HotelService.delete(id);
    return new ResponseEntity<>(response, response.getStatus());
    }

}
