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

@Entity(name = "Vuelo")
public class Vuelo {

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
   
    @Column(name="Aerolinea", length = 10, nullable  = false)
    private String Aerolinea;
   
    @Column(name="NumeroVuelo", length = 100, nullable  = false)
    private String NumeroVuelo;

    @Column(name="Aeropuerto_Origen", length = 100, nullable  = false)
    private String Aeropuerto_Origen;

    @Column(name="Aeropuerto_Destino", length = 100, nullable  = false)
    private String Aeropuerto_Destino;

    @Column(name="Fecha_Hora_Salida", length = 100, nullable  = false)
    private LocalDateTime Fecha_Hora_Salida;

    @Column(name="Fecha_Hora_llegada", length = 100, nullable  = false)
    private LocalDateTime Fecha_Hora_llegada;

     @OneToMany(mappedBy = "Vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paquete> Paquete = new ArrayList<>();

    public Vuelo() {
    }

    public Vuelo(int id, String aerolinea, String numeroVuelo, String aeropuerto_Origen, String aeropuerto_Destino,
            LocalDateTime fecha_Hora_Salida, LocalDateTime fecha_Hora_llegada) {
        this.id = id;
        Aerolinea = aerolinea;
        NumeroVuelo = numeroVuelo;
        Aeropuerto_Origen = aeropuerto_Origen;
        Aeropuerto_Destino = aeropuerto_Destino;
        Fecha_Hora_Salida = fecha_Hora_Salida;
        Fecha_Hora_llegada = fecha_Hora_llegada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAerolinea() {
        return Aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        Aerolinea = aerolinea;
    }

    public String getNumeroVuelo() {
        return NumeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        NumeroVuelo = numeroVuelo;
    }

    public String getAeropuerto_Origen() {
        return Aeropuerto_Origen;
    }

    public void setAeropuerto_Origen(String aeropuerto_Origen) {
        Aeropuerto_Origen = aeropuerto_Origen;
    }

    public String getAeropuerto_Destino() {
        return Aeropuerto_Destino;
    }

    public void setAeropuerto_Destino(String aeropuerto_Destino) {
        Aeropuerto_Destino = aeropuerto_Destino;
    }

    public LocalDateTime getFecha_Hora_Salida() {
        return Fecha_Hora_Salida;
    }

    public void setFecha_Hora_Salida(LocalDateTime fecha_Hora_Salida) {
        Fecha_Hora_Salida = fecha_Hora_Salida;
    }

    public LocalDateTime getFecha_Hora_llegada() {
        return Fecha_Hora_llegada;
    }

    public void setFecha_Hora_llegada(LocalDateTime fecha_Hora_llegada) {
        Fecha_Hora_llegada = fecha_Hora_llegada;
    }

    
   
  

}
