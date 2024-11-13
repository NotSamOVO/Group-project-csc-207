import org.json.JSONException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * BasketBallDataBase is an interface that defines the methods for interacting with the TeamUserCase API.
 */
public interface BasketBallDataBase {
    /**
     * A method that returns a specific team by its ID.
     *
     * @param teamId is the ID of the team.
     * @return the team with the specified ID.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    JSONObject getTeam(int teamId) throws JSONException;

    /**
     * A method that returns a specific player by their ID.
     *
     * @param playerName is the ID of the player.
     * @return the player with the specified ID.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    JSONObject getPlayer(String playerName) throws JSONException;

    /**
     * A method that returns all players in the league.
     *
     * @return an array of all players.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    JSONArray getAllPlayers() throws JSONException;

    /**
     * A method that returns a specific game by its ID.
     *
     * @param gameId is the ID of the game.
     * @return the game with the specified ID.
     * @throws JSONException if an error occurs while parsing the JSON response.
     */
    JSONObject getGame(int gameId) throws JSONException;

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
    JSONObject getSeasonInfo(int year) throws JSONException;
}