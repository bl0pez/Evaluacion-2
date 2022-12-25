/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluaciondos;

/**
 *
 * @author blope
 */
public class Repuesto {
    
    private int codigo;
    private String marca;
    private String nombre;
    private Double precio;
    private int cantidad;

    public Repuesto(int codigo, String marca, String nombre, Double precio, int cantidad) {
        validarCampoInt(codigo, "El campo codigo es obligatorio");
        validarCampoString(nombre, "El campo nombre es obligatorio");
        validarCampoString(marca, "El campo marca es obligatorio");
        validarCampoInt(cantidad, "El campo cantidad es obligatorio y debe ser mayor a cero");
        
        this.codigo = codigo;
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        validarCampoInt(codigo, "El campo codigo es obligatorio");
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        validarCampoString(marca, "El campo marca es obligatorio");
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarCampoString(nombre, "El campo nombre es obligatorio");
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        validarCampoInt(cantidad, "El campo cantidad es obligatorio y debe ser mayor a cero");
        this.cantidad = cantidad;
    }

    public String ListarRepuesto(){
        String mensaje = String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |", codigo, marca, nombre, precio, cantidad);
        return mensaje;
        /* return "Codigo: " + codigo + " Marca: " + marca + " Nombre: " + nombre + " Precio: " + precio + " Cantidad: " + cantidad; */
    }

    /**
     * Método que valida que los campos no sean nulos o vacíos
     * @param valor - campo  a validar de tipo String
     * @param mensaje - mensaje de error que mostrara si el campo es nulo o vacío
     * @throws validarCampoString - excepción que se lanza si el campo es nulo o vacío
     */
    private void validarCampoString(String valor, String mensaje){
        if(valor == null || valor.isEmpty()){
            throw new IllegalArgumentException(mensaje);
        }
    }

    /**
     * Método que valida que los campos no sean nulos y mayores a cero
     * @param valor - campo  a validar de tipo int
     * @param mensaje - mensaje de error que mostrara si el campo es nulo y menor a cero
     * @throws validarCampoInt - excepción que se lanza si el campo es nulo y menor a cero
     */
    private void validarCampoInt(int valor, String mensaje){
        if(valor <= 0){
            throw new IllegalArgumentException(mensaje);
        }
    }

}
