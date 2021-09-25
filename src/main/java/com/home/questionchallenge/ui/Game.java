package com.home.questionchallenge.ui;

import com.home.questionchallenge.models.*;
import com.home.questionchallenge.utils.GameSetup;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class Game {

    private Game(){}

    private static Scanner sc = new Scanner(System.in);

    public static void play(){

        System.out.println("\nIngrese su nombre para iniciar el juego: ");
        String playerName = sc.nextLine();
        Player player = new Player(playerName);

        System.out.println("\n¡Que empiecen los Septuagésimo Cuartos Juegos del Hambre y que la suerte esté siempre de tú parte  " + playerName + "!");

        Session session = GameSetup.setUp(player);

        for (Round round : session.getRoundList()){
            Question question = round.getQuestionRound();
            String choice = validateQuestion(question);

            if(choice.equals("0")){
                System.out.println("\nHas decidido retirarte. Bien jugado " + playerName + "." + "Tu puntaje final es: " + player.getScore());
                break;
            }

            if (question.validateWrongAnswer(choice)){
                player.setScore(0);
                System.out.println("\nLo siento " + playerName + " , has fallado y lo has perdido todo . Nos vemos pronto.");
                break;
            }

            System.out.println("\nExcelente " + playerName + " Tu respuesta es correcta, continua jugando así.");

            player.setScore(player.getScore() + round.getRoundScore());
        }

        if (player.getScore() == session.getMaximumScore()){
            System.out.println("\nWOW, eres sorprendente, " + playerName + " ¡has ganado! Tu puntaje final es: " + player.getScore() );
        }

    }

    private static String validateQuestion(Question question) {

        List<String> possibleChoices = Arrays.asList("1", "2", "3", "4", "0");
        String choice;
        boolean validChoice;

        do {
            System.out.println("\nPREGUNTA: " + question.getQuestionTitle());
            System.out.println("\nElija una opción entre las siguientes respuestas: ");
            for (Answer answer : question.getAnswerList()) {
                System.out.println(answer.getId() + ": " + answer.getTitle());
            }
            System.out.println("\nSi desea retirarse del juego por favor ingrese 0");
            choice = sc.nextLine();
            validChoice = possibleChoices.contains(choice);

            if (validChoice) {
                return choice;
            } else {
                System.out.println("\nADVERTENCIA: Por favor, ingrese una opción válida: ");
            }
        } while (!validChoice);
        return "PENDIENTE POR SELECCIÓN";
    }


}
