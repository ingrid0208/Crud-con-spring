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

@Entity(name = "Excursion")
public class Excursion {

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
   
    @Column(name="Descripcion", length = 100, nullable  = false)
    private String Descripcion;
   
    @Column(name="Duracion", length = 100, nullable  = false)
    private String Duracion;

    @Column(name="Actividades_Incluidas", length = 100, nullable  = false)
    private String Actividades_Incluidas;

    @OneToMany(mappedBy = "Excursion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paquete> Paquete = new ArrayList<>();

    public Excursion() {
    }

    public Excursion(int id, String nombre, String descripcion, String duracion, String actividades_Incluidas) {
        this.id = id;
        Nombre = nombre;
        Descripcion = descripcion;
        Duracion = duracion;
        Actividades_Incluidas = actividades_Incluidas;
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

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    public String getActividades_Incluidas() {
        return Actividades_Incluidas;
    }

    public void setActividades_Incluidas(String actividades_Incluidas) {
        Actividades_Incluidas = actividades_Incluidas;
    }

    

    
   
}
