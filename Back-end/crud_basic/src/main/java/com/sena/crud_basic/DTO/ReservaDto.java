package com.sena.crud_basic.DTO;

import java.time.LocalDate;

public class ReservaDto {

    private int id;
    private LocalDate FechaReserva;
    private  String Estado;
    private int id_cliente;
    private int id_Paquete;
    public ReservaDto() {
    }
    public ReservaDto(int id, LocalDate fechaReserva, String estado, int id_cliente, int id_Paquete) {
        this.id = id;
        FechaReserva = fechaReserva;
        Estado = estado;
        this.id_cliente = id_cliente;
        this.id_Paquete = id_Paquete;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getFechaReserva() {
        return FechaReserva;
    }
    public void setFechaReserva(LocalDate fechaReserva) {
        FechaReserva = fechaReserva;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getId_Paquete() {
        return id_Paquete;
    }
    public void setId_Paquete(int id_Paquete) {
        this.id_Paquete = id_Paquete;
    }

    


    

    

}
