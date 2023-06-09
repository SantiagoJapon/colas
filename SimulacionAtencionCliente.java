/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.ejercicioscolas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author MSIBRAVO
 */
public class SimulacionAtencionCliente {

    private static Queue<String> colaClientes = new LinkedList<>();
    private static int clientesAtendidos = 0;
    private static int tiempoEsperaTotal = 0;

    public static void llegadaCliente(String cliente) {
        colaClientes.add(cliente);
        System.out.println("Llegó un nuevo cliente: " + cliente);
    }

    public static void atencionCliente() {
        if (!colaClientes.isEmpty()) {
            String cliente = colaClientes.poll();
            procesarSolicitud(cliente);
            System.out.println("Atendiendo al cliente: " + cliente);
            clientesAtendidos++;
        } else {
            System.out.println("No hay clientes en espera.");
        }
    }

    public static void procesarSolicitud(String cliente) {
        // Simulación del tiempo que toma procesar la solicitud
        Random random = new Random();
        int tiempoEspera = random.nextInt(15) + 1;  // Tiempo de espera entre 1 y 5 unidades
        tiempoEsperaTotal += tiempoEspera;
        try {
            Thread.sleep(tiempoEspera * 2000);  // Esperar en milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void simulacion(int tiempo) {
        Random random = new Random();
        int umbral = 8;  // Umbral para determinar la llegada de un nuevo cliente

        for (int i = 1; i <= tiempo; i++) {
            int numeroAleatorio = random.nextInt(10) + 1;
            if (numeroAleatorio > umbral) {
                String nuevoCliente = "Cliente " + i;
                llegadaCliente(nuevoCliente);
            }
            atencionCliente();
        }

        mostrarEstadisticas();
    }

    public static void mostrarEstadisticas() {
        System.out.println("Estadísticas de la simulación:");
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Tiempo promedio de espera: " + (double) tiempoEsperaTotal / clientesAtendidos + " unidades");
    }

    public static void main(String[] args) {
        int tiempoSimulacion = 10;  // Duración de la simulación en unidades de tiempo
        simulacion(tiempoSimulacion);
    }
   
 
}

