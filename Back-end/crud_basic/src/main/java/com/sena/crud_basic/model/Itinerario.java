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

@Entity(name = "Itinerario")
public class Itinerario {
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

 @Column(name="Description_Dias", length = 10, nullable  = false)
 private String Description_Dias;

 @Column(name="Actividades_Programadas", length = 100, nullable  = false)
 private String Actividades_Programadas;

 @OneToMany(mappedBy = "Itinerario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paquete> Paquete = new ArrayList<>();

 public Itinerario() {
 }

 public Itinerario(int id, String description_Dias, String actividades_Programadas) {
   this.id = id;
   Description_Dias = description_Dias;
   Actividades_Programadas = actividades_Programadas;
 }

 public int getId() {
   return id;
 }

 public void setId(int id) {
   this.id = id;
 }

 public String getDescription_Dias() {
   return Description_Dias;
 }

 public void setDescription_Dias(String description_Dias) {
   Description_Dias = description_Dias;
 }

 public String getActividades_Programadas() {
   return Actividades_Programadas;
 }

 public void setActividades_Programadas(String actividades_Programadas) {
   Actividades_Programadas = actividades_Programadas;
 }

 


}
