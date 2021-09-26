package com.home.questionchallenge.repository;

import com.home.questionchallenge.models.Player;
import com.home.questionchallenge.utils.DatabaseConnection;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private UserRepository(){}

    private static final String QUERY_LIST = "SELECT * FROM players ORDER BY game_date DESC";
    private static final String QUERY_SAVE ="INSERT INTO players (name,score,game_date)VALUES (?,?,?)";

    public static List<Player> list(){

        List<Player> playerList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet rs = statement.executeQuery(QUERY_LIST)){

            while (rs.next()){
                Player player = createPlayer(rs);
                playerList.add(player);
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error en la visualización del historico de puntajes, lamentamos la molestia. Detalle error: " + e.getMessage());
    }
        return playerList;
    }

    public static void save(Player player){
        try (PreparedStatement stmt = getConnection().prepareStatement(QUERY_SAVE)) {
            stmt.setString(1, player.getName());
            stmt.setInt(2, player.getScore());
            stmt.setObject(3, LocalDateTime.now());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error en el guardado de su puntaje, lamentamos la molestia. Detalle error: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }

    private static Player createPlayer(ResultSet rs) throws SQLException {
        Player player = new Player(rs.getString("name"));
        player.setScore(rs.getInt("score"));
        player.setGameDate(LocalDateTime.parse(rs.getString("game_date")));
        return player;
    }
}
