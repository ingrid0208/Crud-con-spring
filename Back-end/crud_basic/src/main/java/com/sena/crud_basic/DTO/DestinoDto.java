package com.sena.crud_basic.DTO;

public class DestinoDto {

    private int id;
    private String nombre;
    private String cuidad;
    private String pais;
    private String descripcion;

    public DestinoDto(){

    }

    public DestinoDto(int id, String nombre, String cuidad, String pais, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.cuidad = cuidad;
        this.pais = pais;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
