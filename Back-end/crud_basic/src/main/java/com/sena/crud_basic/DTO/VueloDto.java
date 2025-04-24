package com.sena.crud_basic.DTO;

import java.time.LocalDateTime;

public class VueloDto {

    private int id;
    private String Aerolinea;
    private String Numero_Vuelo;
    private String Aeropuerto_Origen;
    private String Aeropuerto_Destino;
    private LocalDateTime Fecha_Hora_Salida;
    private LocalDateTime Fecha_Hora_Llegada;

    public VueloDto() {
    }

    public VueloDto(int id, String aerolinea, String numero_vuelo, String aeropuerto_origen, String aeropuerto_destino, LocalDateTime fecha_hora_salida, LocalDateTime fecha_hora_llegada) {
        this.id = id;
        this.Aerolinea = aerolinea;
        this.Numero_Vuelo = numero_vuelo;
        this.Aeropuerto_Origen = aeropuerto_origen;
        this.Aeropuerto_Destino = aeropuerto_destino;
        this.Fecha_Hora_Salida = fecha_hora_salida;
        this.Fecha_Hora_Llegada = fecha_hora_llegada;
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

    public String getNumero_Vuelo() {
        return Numero_Vuelo;
    }

    public void setNumero_Vuelo(String numero_Vuelo) {
        Numero_Vuelo = numero_Vuelo;
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

    public LocalDateTime getFecha_Hora_Llegada() {
        return Fecha_Hora_Llegada;
    }

    public void setFecha_Hora_Llegada(LocalDateTime fecha_Hora_Llegada) {
        Fecha_Hora_Llegada = fecha_Hora_Llegada;
    }

    


}
