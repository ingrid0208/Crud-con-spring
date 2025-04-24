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

@Entity(name = "Cliente")
public class Cliente {
    // @Id= indica que es la primary key
    @Id
    // @column=indica qeu es una columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 10, nullable = false)
    /*
     * name = nombre de la columna en la base de datos
     * length=longitud del campo
     * nullable = si acepta null o no
     */
    private int id;

    @Column(name = "Nombre", length = 10, nullable = false)
    private String name;

    @Column(name = "Apellido", length = 100, nullable = false)
    private String Apellido;

    @Column(name = "Direccion", length = 100, nullable = false)
    private String Direccion;

    @Column(name = "telefono", length = 100, nullable = false)
    private String telefono;

    @Column(name = "Email", length = 100, nullable = false)
    private String Email;

    @OneToMany(mappedBy = "Cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> Reserva = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int id, String name, String apellido, String direccion, String telefono, String email) {
        this.id = id;
        this.name = name;
        Apellido = apellido;
        Direccion = direccion;
        this.telefono = telefono;
        Email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
