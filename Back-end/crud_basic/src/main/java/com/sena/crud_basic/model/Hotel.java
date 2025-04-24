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

@Entity(name = "Hotel")
public class Hotel {

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

 @Column(name="Dirreccion", length = 100, nullable  = false)
 private String Dirreccion;

 @Column(name="Numero_Estrellas", length = 100, nullable  = false)
 private String Numero_Estrellas;

 @Column(name="Telefono", length = 100, nullable  = false)
 private String Telefono;

 @OneToMany(mappedBy = "Hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paquete> Paquete = new ArrayList<>();

 public Hotel() {
 }

 public Hotel(int id, String nombre, String dirreccion, String numero_Estrellas, String telefono) {
    this.id = id;
    Nombre = nombre;
    Dirreccion = dirreccion;
    Numero_Estrellas = numero_Estrellas;
    Telefono = telefono;
    
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

 public String getDirreccion() {
    return Dirreccion;
 }

 public void setDirreccion(String dirreccion) {
    Dirreccion = dirreccion;
 }

 public String getNumero_Estrellas() {
    return Numero_Estrellas;
 }

 public void setNumero_Estrellas(String numero_Estrellas) {
    Numero_Estrellas = numero_Estrellas;
 }

 public String getTelefono() {
    return Telefono;
 }

 public void setTelefono(String telefono) {
    Telefono = telefono;
 }



}
