package com.sena.crud_basic.DTO;

import java.time.LocalDateTime;

public class TransporteDto {

    private int id;
    private String Tipo;
    private String Empresa;
    private LocalDateTime Horario_Salida;
    private LocalDateTime Horario_llegada;

    public TransporteDto() {
    }

    public TransporteDto(int id, String tipo, String empresa, LocalDateTime horario_Salida, LocalDateTime horario_llegada){
        this.id = id;
        this.Tipo = tipo;
        this.Empresa = empresa;
        this.Horario_Salida = horario_Salida;
        this.Horario_llegada = horario_llegada;
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

    public void setHorario_Salida(LocalDateTime horario_Salida) {
        Horario_Salida = horario_Salida;
    }

    public LocalDateTime getHorario_llegada() {
        return Horario_llegada;
    }

    public void setHorario_llegada(LocalDateTime horario_llegada) {
        Horario_llegada = horario_llegada;
    }

    
}

