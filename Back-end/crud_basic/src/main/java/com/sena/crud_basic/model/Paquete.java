package com.sena.crud_basic.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "Paquete")
public class Paquete {

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

 @Column(name="Descricion", length = 100, nullable  = false)
 private String Descricion;

 @Column(name="Precio", length = 100, nullable  = false)
 private Double Precio;

 @OneToMany(mappedBy = "Paquete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> Reserva = new ArrayList<>();

      @ManyToOne
      @JoinColumn(name = "id_destino", referencedColumnName = "id")
        private destino destino;
  
      @ManyToOne
      @JoinColumn(name = "id_vuelo", referencedColumnName = "id")
      private Vuelo Vuelo;

      @ManyToOne
      @JoinColumn(name = "id_hotel", referencedColumnName = "id")
      private Hotel Hotel;

      @ManyToOne
      @JoinColumn(name = "id_excursion", referencedColumnName = "id")
      private Excursion Excursion;

      @ManyToOne
      @JoinColumn(name = "id_transporte", referencedColumnName = "id")
      private Transporte Transporte;

      @ManyToOne
      @JoinColumn(name = "id_seguro", referencedColumnName = "id")
      private Seguro Seguro;

      @ManyToOne
      @JoinColumn(name = "id_itinerario", referencedColumnName = "id")
      private Itinerario Itinerario;

      public Paquete() {
      }

      public Paquete(int id, String nombre, String descricion, Double precio,
          List<com.sena.crud_basic.model.Reserva> reserva, com.sena.crud_basic.model.destino destino,
          com.sena.crud_basic.model.Vuelo vuelo, com.sena.crud_basic.model.Hotel hotel,
          com.sena.crud_basic.model.Excursion excursion, com.sena.crud_basic.model.Transporte transporte,
          com.sena.crud_basic.model.Seguro seguro, com.sena.crud_basic.model.Itinerario itinerario) {
        this.id = id;
        Nombre = nombre;
        Descricion = descricion;
        Precio = precio;
        Reserva = reserva;
        this.destino = destino;
        Vuelo = vuelo;
        Hotel = hotel;
        Excursion = excursion;
        Transporte = transporte;
        Seguro = seguro;
        Itinerario = itinerario;
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

      public String getDescricion() {
        return Descricion;
      }

      public void setDescricion(String descricion) {
        Descricion = descricion;
      }

      public Double getPrecio() {
        return Precio;
      }

      public void setPrecio(Double precio) {
        Precio = precio;
      }

      public List<Reserva> getReserva() {
        return Reserva;
      }

      public void setReserva(List<Reserva> reserva) {
        Reserva = reserva;
      }

      public destino getDestino() {
        return destino;
      }

      public void setDestino(destino destino) {
        this.destino = destino;
      }

      public Vuelo getVuelo() {
        return Vuelo;
      }

      public void setVuelo(Vuelo vuelo) {
        Vuelo = vuelo;
      }

      public Hotel getHotel() {
        return Hotel;
      }

      public void setHotel(Hotel hotel) {
        Hotel = hotel;
      }

      public Excursion getExcursion() {
        return Excursion;
      }

      public void setExcursion(Excursion excursion) {
        Excursion = excursion;
      }

      public Transporte getTransporte() {
        return Transporte;
      }

      public void setTransporte(Transporte transporte) {
        Transporte = transporte;
      }

      public Seguro getSeguro() {
        return Seguro;
      }

      public void setSeguro(Seguro seguro) {
        Seguro = seguro;
      }

      public Itinerario getItinerario() {
        return Itinerario;
      }

      public void setItinerario(Itinerario itinerario) {
        Itinerario = itinerario;
      }

      

  
 


}
