package com.sena.crud_basic.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sena.crud_basic.model.Paquete;

@Repository
public interface IPaquete 
 extends JpaRepository<Paquete,Integer>{

}
