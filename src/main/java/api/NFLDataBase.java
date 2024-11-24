package api;

<<<<<<< HEAD
import entity.Game;
=======
>>>>>>> origin/main
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import entity.Player;
import entity.Team;

import java.util.ArrayList;

/**
 * BasketBallDataBase is an interface that defines the methods for interacting with the TeamUserCase API.
 */
public interface NFLDataBase {
    /**
     * A method that returns a specific team by its ID.
     *
     * @param teamId is the ID of the team.
     * @return the team with the specified ID.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    Team getTeam(int teamId) throws JSONException;

    /**
     * A method that returns all teams in the league.
     * @return ArrayList of all teams.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    ArrayList<Team> getAllTeams() throws JSONException;

    /**
     * A method that returns a specific player by their ID.
     *
     * @param playerId is the ID of the player.
     * @return the player with the specified ID.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    Player getPlayer(int playerId) throws JSONException;

    /**
     * A method that returns all players in the league.
     *
     * @return an ArrayList of all players.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    ArrayList<Player> getAllPlayers() throws JSONException;

    /**
     * A method that returns a specific game by its ID.
     *
     * @param gameId is the ID of the game.
     * @return the game with the specified ID.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    Game getGame(int gameId) throws JSONException;

    /**
     * A method that returns all games.
     *
     * @return all games.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    ArrayList<Game> getAllGames() throws JSONException;

    /**
     * A method that returns games for a specific date.
     *
     * @param date is the date for which to retrieve games (format: "YYYY-MM-DD").
     * @return an array of games on the specified date.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    JSONArray getGamesByDate(String date) throws JSONException;

    /**
     * A method that returns information about a specific season.
     *
     * @param year is the year of the season (e.g., 2021 for the 2021-2022 season).
     * @return the Season object containing information about the specified season.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    JSONArray getSeasonInfo(int year) throws JSONException;
}
