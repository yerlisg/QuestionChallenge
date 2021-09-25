package com.home.questionchallenge;

import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int response = 0;

        System.out.println("BIENVENIDO");
        System.out.println("************ JUEGO DE PREGUNTAS ************");

       do {
           System.out.println("Elija una opción: ");
           System.out.println("1. Jugar");
           System.out.println("2. Ver Lista de puntajes");
           System.out.println("3. Salir");

           response = Integer.parseInt(sc.nextLine());

           switch (response){
               case 1:
                   break;
               case 2:
                   System.out.println(" Lista");
                   break;
               case 3:
                   System.out.println("Gracias por su visita");
                   break;
               default:
                   System.out.println("Por favor seleccione una opción válida");
           }
       } while (response != 3);

    }
}
