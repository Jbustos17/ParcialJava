package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CabinaTelefonica> cabinas = new ArrayList<>();
        int opcion;


        do {
            System.out.println("1. Crear Cabina Telefonica");
            System.out.println("2. Escoger Cabina Telefonica");
            System.out.println("3. Mostrar Informacion Detallada Por Cabina");
            System.out.println("4. Mostrar Consolidado Total De La Informacion De Las Cabinas ");
            System.out.println("5. Reiniciar Cabina ");
            opcion = scanner.nextInt();


            switch (opcion) {

                case 1:
                CabinaTelefonica cabina = new CabinaTelefonica(cabinas.size() + 1);
                cabinas.add(cabina);
                System.out.println("Cabina creada con ID: " + cabina.getId());
                break;

                case 2:
                    System.out.println("Ingrese el id de la cabina");
                    int id = scanner.nextInt();
                    System.out.print("Tipo de llamada (1:Local, 2:Larga Distancia, 3:Celular):");
                    int tipo = scanner.nextInt();
                    System.out.print("Duracion en minutos: ");
                    int minutos = scanner.nextInt();
                    if (id > 0 && id <= cabinas.size()) {
                        cabinas.get(id - 1).registrarLlamadas(tipo, minutos);
                    } else {
                        System.out.println("Cabina no encontrada");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el id de la cabina:");
                    id = scanner.nextInt();
                    if (id > 0 && id <= cabinas.size()) {
                        cabinas.get(id - 1).mostrarInformacion();
                    } else {
                        System.out.println("Cabina no encontrada");
                    }
                    break;

                case 4:
                    int totalLlamadas = 0, totalMinutos = 0, totalCosto = 0;
                    for (CabinaTelefonica c : cabinas) {
                        totalLlamadas += c.getTotalLlamadas();
                        totalMinutos += c.getTotalMinutos();
                        totalCosto += c.calcularCostoTotal();
                    }
                    System.out.println("Total de llamadas: " + totalLlamadas);
                    System.out.println("Total de minutos: " + totalMinutos);
                    System.out.println("Costo total: " + totalCosto );
                    break;

                case 5 :
                    System.out.print("Ingrese el id de la cabina: ");
                    id = scanner.nextInt();
                    if (id > 0 && id <= cabinas.size()) {
                        cabinas.get(id - 1).reiniciarCabina();
                    } else {
                        System.out.println("Cabina no encontrada.");
                    }
                    break;

            }

        }while (opcion != 5);

        scanner.close();

    }
}

