package com.home.questionchallenge;

import com.home.questionchallenge.ui.Game;
import com.home.questionchallenge.ui.ScoreList;

import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String response;

        System.out.println("************     BIENVENIDO     ************");
        System.out.println("************ JUEGO DE PREGUNTAS ************\n");

       do {
           System.out.println("Elija una opción: \n ");
           System.out.println("1. Jugar");
           System.out.println("2. Ver Lista de puntajes");
           System.out.println("3. Salir");

           response = sc.nextLine();

           switch (response){
               case "1":
                   Game.play();
                   break;
               case "2":
                   ScoreList.showScoreList();
                   break;
               case "3":
                   System.out.println("Gracias por su visita");
                   break;
               default:
                   System.out.println("Por favor seleccione una opción válida\n");
           }
       } while (!response.equals("3"));
    }
}
