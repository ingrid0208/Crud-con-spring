package com.sena.crud_basic.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "Transporte")
public class Transporte {

    @Id
    //@column=indica qeu es una columna
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 10, nullable  = false)
    /*
    * name = nombre de la columna en la base de datos
    * length=longitud del campo
    * nullable = si acepta null o no 
    */
    private int id;
   
    
    @Column(name="Tipo", length = 100, nullable  = false)
    private String Tipo;
   
    @Column(name="Empresa", length = 100, nullable  = false)
    private String Empresa;
   

    @Column(name="Hora_Salida", length = 100, nullable  = false)
    private LocalDateTime Horario_Salida;

    @Column(name="Hora_llegada", length = 100, nullable  = false)
    private LocalDateTime Horario_llegada;

    @OneToMany(mappedBy = "Transporte", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paquete> Paquete = new ArrayList<>();

    public Transporte() {
    }


    public Transporte(int id, String tipo, String empresa, LocalDateTime horario_Salida,
    LocalDateTime horario_llegada) {
        this.id = id;
        Tipo = tipo;
        Empresa = empresa;
        Horario_Salida = horario_Salida;
        Horario_llegada = horario_llegada;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
 
    public String getTipo() {
        return Tipo;
    }


    public void setTipo(String tipo) {
        Tipo = tipo;
    }


    public String getEmpresa() {
        return Empresa;
    }


    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }

    public LocalDateTime getHorario_Salida() {
        return Horario_Salida;
    }


    public void setHora_Salida(LocalDateTime horario_Salida) {
        Horario_Salida = horario_Salida;
    }


    public LocalDateTime getHorario_llegada() {
        return Horario_llegada;
    }


    public void setHorario_llegada(LocalDateTime horario_llegada) {
        Horario_llegada = horario_llegada;
    }

   
    

    
}
