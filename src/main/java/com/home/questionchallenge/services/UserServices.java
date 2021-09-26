package com.home.questionchallenge.services;

import com.home.questionchallenge.models.Player;
import com.home.questionchallenge.repository.UserRepository;

import java.util.List;

public class UserServices {

    private UserServices(){}

    public static List<Player> listPlayerScores(){return UserRepository.list();}

    public static void savePlayerScore(Player player){ UserRepository.save(player);}

}


