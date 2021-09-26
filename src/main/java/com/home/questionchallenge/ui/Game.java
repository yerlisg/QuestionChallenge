package com.home.questionchallenge.ui;

import com.home.questionchallenge.models.*;
import com.home.questionchallenge.services.UserServices;
import com.home.questionchallenge.utils.GameSetup;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class Game {

    private Game(){}

    private static Scanner sc = new Scanner(System.in);

    public static void play(){

        System.out.println("Ingrese su nombre para iniciar el juego:");
        String playerName = sc.nextLine();
        Player player = new Player(playerName);

        System.out.println("¡Que empiecen los Septuagésimo Cuartos Juegos del Hambre y que la suerte esté siempre de tu parte " + playerName + "!\n");

        Session session = GameSetup.setUp(player);

        for (Round round : session.getRoundList()){
            Question question = round.getRoundQuestion();
            String choice = validateQuestion(question);

            if(choice.equals("0")){
                System.out.println("Has decidido retirarte. Bien jugado " + playerName + ". Tu puntaje final es: " + player.getScore()+ "\n");
                break;
            }
            if (question.validateWrongAnswer(choice)){
                player.setScore(0);
                System.out.println("Lo siento " + playerName + ", has fallado y lo has perdido todo. Nos vemos pronto.\n");
                break;
            }
            player.setScore(player.getScore() + round.getRoundScore());
            System.out.println("Excelente " + playerName + ", tu respuesta es correcta, continua jugando así. Tu puntaje acumulado es de: "+player.getScore() +"\n");
        }

        if (player.getScore() == session.getMaximumScore()){
            System.out.println("WOW, eres sorprendente, " + playerName + "¡has ganado! Tu puntaje final es: " + player.getScore() + "\n" );
        }

        UserServices.savePlayerScore(player);
    }

    private static String validateQuestion(Question question) {

        List<String> possibleChoices = Arrays.asList("1", "2", "3", "4", "0");
        String choice;
        boolean validChoice;

        do {
            System.out.println("PREGUNTA: " + question.getQuestionTitle()+ "\n");
            System.out.println("Elija una opción entre las siguientes respuestas:\n ");
            for (Answer answer : question.getAnswerList()) {
                System.out.println(answer.getId() + ": " + answer.getTitle());
            }
            System.out.println("Si desea retirarse del juego por favor ingrese 0 \n");

            choice = sc.nextLine();
            validChoice = possibleChoices.contains(choice);

            if (validChoice) {
                return choice;
            }
            System.out.println("ADVERTENCIA: Por favor, ingrese una opción válida:\n ");

        } while (!validChoice);
        return "PENDIENTE POR SELECCIÓN";
    }
}
