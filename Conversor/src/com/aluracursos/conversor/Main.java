package com.aluracursos.conversor;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consulta consulta = new Consulta();

        while (true) {

            System.out.println("Seleccione una moneda para convertir:");
            System.out.println("1. DOLAR EEUU      => PESO CHILE");
            System.out.println("2. PESO ARGENTINO  => BOLIVIANO");
            System.out.println("3. PESO COLOMBIA   => DOLAR CANADA");
            System.out.println("4. REAL BRASIL     => DOLAR EEUU");
            System.out.println("5. PESO MEXICO     => EURO");
            System.out.println("6. SALIR");

            System.out.print("Seleccione una opción de cambio: ");
            int opcion = scanner.nextInt();

            if (opcion == 6) {
                System.out.println("Hasta la próxima");
                break;
            } else if (opcion < 1 || opcion > 6) {
                System.out.println("Error. Por favor intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            String base = "";
            String destino = "";


            switch (opcion) {
                case 1 -> { base = "USD"; destino = "CLP"; }
                case 2 -> { base = "ARS"; destino = "BOB"; }
                case 3 -> { base = "COP"; destino = "CAD"; }
                case 4 -> { base = "BRL"; destino = "USD"; }
                case 5 -> { base = "MXN"; destino = "EUR"; }
            }

            try {
                Moneda moneda = consulta.obtenerConversion(base, destino);
                double resultado = moneda.conversion_rate() * cantidad;


                System.out.printf("El valor de %.2f [%s] es %.2f [%s]%n",
                        cantidad, moneda.base_code(), resultado, moneda.target_code());

                generador.guardarJson(moneda);
                System.out.println("Conversión guardada en archivo JSON.");
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
