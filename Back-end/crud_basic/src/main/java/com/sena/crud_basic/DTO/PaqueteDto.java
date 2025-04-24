package com.sena.crud_basic.DTO;

public class PaqueteDto {

    private int id;
    private String Nombre;
    private String Descripcion;
    private Double precio;
    private int id_destino;
    private int id_vuelo;
    private int id_hotel;
    private int id_excursion;
    private int id_transporte;
    private int id_seguro;
    private int id_itinerario;

    
    public PaqueteDto() {
    }


    public PaqueteDto(int id, String nombre, String descripcion, Double precio, int id_destino, int id_vuelo,
            int id_hotel, int id_excursion, int id_transporte, int id_seguro, int id_itinerario) {
        this.id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        this.precio = precio;
        this.id_destino = id_destino;
        this.id_vuelo = id_vuelo;
        this.id_hotel = id_hotel;
        this.id_excursion = id_excursion;
        this.id_transporte = id_transporte;
        this.id_seguro = id_seguro;
        this.id_itinerario = id_itinerario;
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


    public String getDescripcion() {
        return Descripcion;
    }


    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public int getId_destino() {
        return id_destino;
    }


    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
    }


    public int getId_vuelo() {
        return id_vuelo;
    }


    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }


    public int getId_hotel() {
        return id_hotel;
    }


    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }


    public int getId_excursion() {
        return id_excursion;
    }


    public void setId_excursion(int id_excursion) {
        this.id_excursion = id_excursion;
    }


    public int getId_transporte() {
        return id_transporte;
    }


    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }


    public int getId_seguro() {
        return id_seguro;
    }


    public void setId_seguro(int id_seguro) {
        this.id_seguro = id_seguro;
    }


    public int getId_itinerario() {
        return id_itinerario;
    }


    public void setId_itinerario(int id_itinerario) {
        this.id_itinerario = id_itinerario;
    }

    

    
}
