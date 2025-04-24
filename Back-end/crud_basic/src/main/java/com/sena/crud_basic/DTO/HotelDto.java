package com.sena.crud_basic.DTO;

public class HotelDto {

    private int id;
    private String Nombre;
    private String Direccion;
    private String Numero_Estrella;
    private String Telefono;

    public HotelDto() {
    }

    public HotelDto(int id, String nombre, String direccion, String numero_Estrella, String telefono){
        this.id = id;
        this.Nombre = nombre;
        this.Direccion = direccion;
        this.Numero_Estrella = numero_Estrella;
        this.Telefono = telefono;

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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNumero_Estrella() {
        return Numero_Estrella;
    }

    public void setNumero_Estrella(String numero_Estrella) {
        Numero_Estrella = numero_Estrella;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    
}
