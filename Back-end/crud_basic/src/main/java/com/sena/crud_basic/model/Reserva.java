package com.sena.crud_basic.model;
import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name = "Reserva")

public class Reserva {

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
   
    @Column(name="FechaReserva", length = 10, nullable  = false)
    private LocalDate FechaReserva;
   
    @Column(name="Estado", length = 100, nullable  = false)
    private String Estado;

        @ManyToOne
        @JoinColumn(name = "id_cliente", referencedColumnName = "id")
        private Cliente Cliente;

        @ManyToOne
        @JoinColumn(name = "id_Paquete", referencedColumnName = "id")
        private Paquete Paquete;

        public Reserva() {
        }

        public Reserva(int id, LocalDate fechaReserva, String estado, com.sena.crud_basic.model.Cliente cliente,
                com.sena.crud_basic.model.Paquete paquete) {
            this.id = id;
            FechaReserva = fechaReserva;
            Estado = estado;
            Cliente = cliente;
            Paquete = paquete;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public LocalDate getFechaReserva() {
            return FechaReserva;
        }

        public void setFechaReserva(LocalDate fechaReserva) {
            FechaReserva = fechaReserva;
        }

        public String getEstado() {
            return Estado;
        }

        public void setEstado(String estado) {
            Estado = estado;
        }

        public Cliente getCliente() {
            return Cliente;
        }

        public void setCliente(Cliente cliente) {
            Cliente = cliente;
        }

        public Paquete getPaquete() {
            return Paquete;
        }

        public void setPaquete(Paquete paquete) {
            Paquete = paquete;
        }


   

    

    

}
