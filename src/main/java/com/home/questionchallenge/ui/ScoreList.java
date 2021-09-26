package com.home.questionchallenge.ui;

import com.home.questionchallenge.models.Player;
import com.home.questionchallenge.services.UserServices;

import java.time.format.DateTimeFormatter;
import java.util.List;

public final class ScoreList {

    private ScoreList() {
    }

    private static final String TABULATION = "\t\t\t";


    public static void showScoreList(){

        System.out.println("************* HISTÓRICO DE PUNTAJES ************");
        List<Player> playerList = UserServices.listPlayerScores();
        int playerCounter = 0;
        for (Player player: playerList){
            StringBuilder sb = new StringBuilder()
                    .append(++playerCounter)
                    .append(TABULATION)
                    .append(player.getName())
                    .append(TABULATION)
                    .append(player.getScore())
                    .append(TABULATION)
                    .append(player.getGameDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a")))
                    .append(TABULATION);
            System.out.println(sb);
        }
    }
}
