package use_case.matchresults;
import api.NFLTeamDataBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The MatchresultsOutputData class provides methods to retrieve and process
 * data related to NFL games, including game descriptions, scores, and dates.
 */
public class MatchResultsUseCase {
    private NFLTeamDataBase nflDataBase;

    /**
     * Constructs a MatchresultsOutputData instance with the specified NFLDataBase.
     *
     * @param nflDataBase the data access interface for retrieving NFL data.
     */
    public MatchResultsUseCase(NFLTeamDataBase nflDataBase) {
        this.nflDataBase = nflDataBase;
    }

    /**
     * Retrieves a formatted string representing the game matchup.
     *
     * @param gameId the unique ID of the game.
     * @return a string in the format "HomeTeam vs VisitorTeam".
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getGame(int gameId) {
        final JSONObject gameJson = nflDataBase.getGame(gameId);

        try {
            final String homeTeam = gameJson.getJSONObject("home_team").getString("full_name");
            final String visitorTeam = gameJson.getJSONObject("visitor_team").getString("full_name");

            return homeTeam + " vs " + visitorTeam;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the score of the game as a formatted string.
     *
     * @param gameId the unique ID of the game.
     * @return a string in the format "VisitorScore-HomeScore".
     * @throws RuntimeException if the game data is malformed or missing.
     */

    public String getScore(int gameId) {
        final JSONObject scoreJson = nflDataBase.getGame(gameId);

        try {
            final Integer homeScore = scoreJson.getInt("home_team_score");
            final Integer visitorScore = scoreJson.getInt("visitor_team_score");

            return homeScore + "-" + visitorScore;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the date of the game.
     *
     * @param gameId the unique ID of the game.
     * @return a string representing the game date in ISO format (e.g., "2024-09-06T00:20:00.000Z").
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getDate(int gameId) {
        final JSONObject dateJson = nflDataBase.getGame(gameId);

        try {
            final String date = dateJson.getString("date");
            return date;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String[][] getdata(int[] gameId) {
        final String[][] data = new String[gameId.length][3];
        for (int i = 0; i < gameId.length; i++) {
            final int gameid = gameId[i];
            data[i][0] = getGame(gameid);
            data[i][1] = getScore(gameid);
            data[i][2] = getDate(gameid);
        }
        return data;
    }

    public int[] getGameId(int teamId) {
        try {
            final JSONObject team = nflDataBase.getTeam(teamId);
            final String teamName = team.getString("name");
            final JSONArray games = nflDataBase.getAllGames();
            final ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < games.length(); i++) {
                final JSONObject game = games.getJSONObject(i);
                final String homeTeam = game.getString("home_team");
                final String visitorTeam = game.getString("visitor_team");
                if (homeTeam.equals(teamName) || visitorTeam.equals(teamName)) {
                    result.add(game.getInt("id"));
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}

