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

@Entity(name = "Seguro")
public class Seguro {
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

 @Column(name="Proveedor", length = 10, nullable  = false)
 private String Proveedor;

 @Column(name="Tipo_Seguro", length = 100, nullable  = false)
 private String Tipo_Seguro;

 @Column(name="Cobertura", length = 100, nullable  = false)
 private String Cobertura;

 @Column(name="Vigencia", length = 100, nullable  = false)
 private String Vigencia;

 
    @OneToMany(mappedBy = "Seguro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paquete> Paquete = new ArrayList<>();

 public Seguro() {
 }

 public Seguro(int id, String proveedor, String tipo_Seguro, String cobertura, String vigencia) {
      this.id = id;
      Proveedor = proveedor;
      Tipo_Seguro = tipo_Seguro;
      Cobertura = cobertura;
      Vigencia = vigencia;
 }

 public int getId() {
      return id;
 }

 public void setId(int id) {
      this.id = id;
 }

 public String getProveedor() {
      return Proveedor;
 }

 public void setProveedor(String proveedor) {
      Proveedor = proveedor;
 }

 public String getTipo_Seguro() {
      return Tipo_Seguro;
 }

 public void setTipo_Seguro(String tipo_Seguro) {
      Tipo_Seguro = tipo_Seguro;
 }

 public String getCobertura() {
      return Cobertura;
 }

 public void setCobertura(String cobertura) {
      Cobertura = cobertura;
 }

 public String getVigencia() {
      return Vigencia;
 }

 public void setVigencia(String vigencia) {
      Vigencia = vigencia;
 }

 
}
