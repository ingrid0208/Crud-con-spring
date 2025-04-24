package com.sena.crud_basic.DTO;

public class ItinerarioDto {

    private int id;
    private String Descripcion_Dias;
    private String Actividades_Programadas;

    public ItinerarioDto() {
    }

    public ItinerarioDto(int id, String descripcion_Dias, String actividades_Programadas) {
        this.id = id;
        this.Descripcion_Dias = descripcion_Dias;
        this.Actividades_Programadas = actividades_Programadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion_Dias() {
        return Descripcion_Dias;
    }

    public void setDescripcion_Dias(String descripcion_Dias) {
        Descripcion_Dias = descripcion_Dias;
    }

    public String getActividades_Programadas() {
        return Actividades_Programadas;
    }

    public void setActividades_Programadas(String actividades_Programadas) {
        Actividades_Programadas = actividades_Programadas;
    }

    
}
