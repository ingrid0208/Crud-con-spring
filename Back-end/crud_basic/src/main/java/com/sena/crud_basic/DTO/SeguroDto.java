package com.sena.crud_basic.DTO;

public class SeguroDto {

    private int id;
    private String Proveedor;
    private String Tipo_Seguro;
    private String Cobertura;
    private String Vigencia;

    public SeguroDto(){

    }

    public SeguroDto(int id, String Proveedor, String Tipo_Seguro, String Cobertura, String Vigencia) {
        this.id = id;
        this.Proveedor = Proveedor;
        this.Tipo_Seguro = Tipo_Seguro;
        this.Cobertura = Cobertura;
        this.Vigencia = Vigencia;
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
