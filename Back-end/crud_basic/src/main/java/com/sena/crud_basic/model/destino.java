package com.sena.crud_basic.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "destino")
public class destino {

    //@Id= indica que es la primary key
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

    @Column(name="Nombre", length = 10, nullable  = false)
    private String Nombre;

    @Column(name="ciudad", length = 100, nullable  = false)
    private String ciudad;

    @Column(name="pais", length = 100, nullable  = false)
    private String pais;
    
    @Column(name="descripcion", length = 100, nullable  = false)
    private String descripcion;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paquete> Paquete = new ArrayList<>();

    public destino() {
    }

    public destino(int id, String nombre, String ciudad, String pais, String descripcion) {
        this.id = id;
        Nombre = nombre;
        this.ciudad = ciudad;
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
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public List<Paquete> getPaquete() {
        return Paquete;
    }

    public void setPaquete(List<Paquete> paquete) {
        Paquete = paquete;
    }

    
    

}
