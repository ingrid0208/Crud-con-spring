package com.sena.crud_basic.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crud_basic.model.Reserva;

@Repository
public interface IReserva 
    extends JpaRepository<Reserva,Integer>{
    }