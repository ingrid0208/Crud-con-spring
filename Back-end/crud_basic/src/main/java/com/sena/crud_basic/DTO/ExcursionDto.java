package com.sena.crud_basic.DTO;

public class ExcursionDto {

    private int id;
    private String Nombre;
    private String Descripcion;
    private String Duracion;
    private String Actividad_Incluidas;

    public ExcursionDto() {
    }

    public ExcursionDto(int id, String nombre, String description, String duracion, String actividad_incluidas) {

        this.id = id;
        this.Nombre = nombre;
        this.Descripcion = description;
        this.Duracion = duracion;
        this.Actividad_Incluidas = actividad_incluidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescription() {
        return Descripcion;
    }

    public void setDescription(String description) {
        this.Descripcion = description;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        this.Duracion = duracion;
    }

    public String getActividad_incluidas() {
        return Actividad_Incluidas;
    }

    public void setActividad_incluidas(String actividad_incluidas) {
        this.Actividad_Incluidas = actividad_incluidas;
    }
    
}
