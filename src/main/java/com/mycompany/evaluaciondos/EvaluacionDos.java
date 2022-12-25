/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.evaluaciondos;

/**
 *
 * @author blope
 */
public class EvaluacionDos {

    public static void main(String[] args) {
        
        // Creamos un pedido
        Pedido pedido = new Pedido("Bryan Lopez");

        // Creamos los repuestos
        Repuesto repuesto1 = new Repuesto(1, "Toyota", "Filtro de aceite", 10000.0, 1);
        Repuesto repuesto2 = new Repuesto(2, "Toyota", "Filtro de aire", 10000.0, 1);
        Repuesto repuesto3 = new Repuesto(2, "Toyota", "Filtro de aire", 10000.0, 1);
        Repuesto repuesto4 = new Repuesto(2, "Toyota", "Filtro de aire", 10000.0, 1);
        Repuesto repuesto5 = new Repuesto(2, "Toyota", "Filtro de aire", 10000.0, 1);
        Repuesto repuesto6 = new Repuesto(3, "Bmw", "Amortiguador", 10000.0, 1);


        // Agregamos los repuestos al pedido
        pedido.agregarRepuesto(repuesto1);
        pedido.agregarRepuesto(repuesto2);
        pedido.agregarRepuesto(repuesto3);
        pedido.agregarRepuesto(repuesto4);
        pedido.agregarRepuesto(repuesto5);
        pedido.agregarRepuesto(repuesto6);

        
        // Imprimimos el pedido
        System.out.println("========== Listado de repuestos =========");
        System.out.println("Nombre del cliente: " + pedido.getNombreCliente());
        pedido.listarRepuestos();
        System.out.println("\n");

        System.out.println("========== Eliminamos un repuesto y lo listamos =========");
        pedido.eliminarRepuesto(2);
        pedido.listarRepuestos();
        System.out.println("\n");

        System.out.println("========== Filtramos por marca =========");
        System.out.println("Total del pedido filtrado por marca: " + pedido.obtenerRepustosMarca("Toyota"));
        System.out.println("Total del pedido filtrado por marca: " + pedido.obtenerRepustosMarca("Bmw"));
        System.out.println("\n");

        System.out.println("========== Mostramos el dinero total del pedido =========");
        System.out.println("Total del pedido: " + pedido.obtenerTotal());
        System.out.println("\n");

    }
}
