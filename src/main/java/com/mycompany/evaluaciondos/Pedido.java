/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluaciondos;

import java.util.ArrayList;

/**
 *
 * @author blope
 */
public class Pedido {
    private String nombreCliente;
    private ArrayList<Repuesto> repuestos;

    //Constructor vacio
    public Pedido(){}

    //Constructor con parametros
    public Pedido(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.repuestos = new ArrayList<Repuesto>();

    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    

    /**
     * Agrega un repuesto al pedido
     * 1- Verificamos que existan repuestos en el pedido
     * 2- Verificamos si el repuesto ya existe, si existe, sumamos la cantidad y el precio
     * 3- Si no existe el repuesto, lo agregamos
     * @param repuesto - Objeto de tipo Repuesto
     * 
     */
    public void agregarRepuesto(Repuesto repuesto){

        //Obtengo el codigo del repuesto
        int codigo = repuesto.getCodigo();

        //Muestro un mensaje de confirmacion
        System.out.println(repuesto.getNombre() + " se agrego correctamente");
        
        //Verificamos que existan repuestos en el pedido
        if(repuestos.size() == 0){
            repuestos.add(repuesto);
            return;
        }

        //Verificamos si el repuesto ya existe, si existe, sumamos la cantidad
        for(Repuesto repuestoExistente : repuestos){
            if(repuestoExistente.getCodigo() == codigo){
                repuestoExistente.setPrecio(repuestoExistente.getPrecio() + repuesto.getPrecio());
                repuestoExistente.setCantidad(repuestoExistente.getCantidad() + repuesto.getCantidad());
                return;
            }
        }

        //Si no existe el repuesto, lo agregamos
        repuestos.add(repuesto);
       
    }

   

    /**
     * Lista todos los repuestos del pedido
     */
    public void listarRepuestos(){
        String mensaje = String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |", "codigo", "marca", "nombre", "precio", "cantidad");
        System.out.println(mensaje);
        for(Repuesto repuesto : repuestos){
            System.out.println(repuesto.ListarRepuesto());
        }
    }

    /**
     * Elimina un repuesto del pedido
     * @param codigo - Codigo del repuesto a eliminar
     */
    public void eliminarRepuesto(int codigo){

        //Recorremos el arreglo de repuestos
        for(int i = 0; i < repuestos.size(); i++){

            //Verificamos si la cantidad es mayor a 1, si es mayor a 1, disminuimos la cantidad y el precio
            if(repuestos.get(i).getCodigo() == codigo && repuestos.get(i).getCantidad() > 1){
                repuestos.get(i).setPrecio(repuestos.get(i).getPrecio() - (repuestos.get(i).getPrecio() / repuestos.get(i).getCantidad()));
                repuestos.get(i).setCantidad(repuestos.get(i).getCantidad() - 1);
                return;
            }

            //Verificamos que sea el codigo del repuesto, si es el codigo, lo eliminamos
            if(repuestos.get(i).getCodigo() == codigo){
                repuestos.remove(i);
                return;
            }

        }
    }

    /**
     * Filtra los repuestos por marca y retorna la cantidad total de repuestos de una marca
     * @param marca
     * @return - Cantidad de repuestos de una marca
     */
    public int obtenerRepustosMarca(String marca){
        
        int cantidad = 0;
        for(Repuesto repuesto : repuestos){
            if(repuesto.getMarca().equals(marca)){
                cantidad += repuesto.getCantidad();
            }
        }

        return cantidad;

    }


    /**
     * Obtiene el total de la compra
     * @return - Total de la compra
     */
    public double obtenerTotal(){
        double total = 0;
        for(Repuesto repuesto : repuestos){
            total += repuesto.getPrecio();
        }
        return total;
    } 
}
