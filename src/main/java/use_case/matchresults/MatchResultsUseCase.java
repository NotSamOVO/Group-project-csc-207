package use_case.matchresults;
import api.NFLDataBase;
import api.NFLTeamDataBase;
import entity.Game;
import entity.Team;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * The MatchResultsUseCase class provides methods to retrieve and process
 * data related to NFL games, including game descriptions, scores, dates,
 * venues, and quarter-specific scores.
 */
public class MatchResultsUseCase {
    private NFLDataBase nflDataBase;

    /**
     * Constructs a MatchresultsOutputData instance with the specified NFLDataBase.
     *
     * @param nflDataBase the data access interface for retrieving NFL data.
     */
    public MatchResultsUseCase(NFLTeamDataBase nflDataBase) {
        this.nflDataBase = nflDataBase;
    }

    /**
     * Retrieves a list of game IDs for a specific team.
     *
     * @param teamName the name of the team.
     * @return a list of game IDs where the specified team participated.
     */
    public ArrayList<Integer> getGameId(String teamName) {
        final ArrayList<Game> allGames = nflDataBase.getAllGames();
        final ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < allGames.size(); i++) {
            boolean check = false;
            final Game game = allGames.get(i);
            final Integer gameId = game.getId();
            final Team homeTeamObj = game.getHome_team();
            final Team visitorTeamObj = game.getVisitor_team();
            final String homeTeam = homeTeamObj.getName();
            final String visitorTeam = visitorTeamObj.getName();
            if (homeTeam.equals(teamName) || visitorTeam.equals(teamName)) {
                check = true;
            }
            if (check) {
                result.add(gameId);
            }
        }
        return result;
    }

    /**
     * Retrieves a formatted string representing the game matchup.
     *
     * @param gameId the unique ID of the game.
     * @return a string in the format "HomeTeam vs VisitorTeam".
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getGame(int gameId) {
        final Game game = nflDataBase.getGame(gameId);

        try {
            final String homeTeam = game.getHome_team().getName();
            final String visitorTeam = game.getVisitor_team().getName();

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
        final Game scoreGame = nflDataBase.getGame(gameId);

        try {
            final Integer homeScore = scoreGame.getHome_team_score();
            final Integer visitorScore = scoreGame.getVisitor_team_score();

            return homeScore + " - " + visitorScore;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the date of the game.
     *
     * @param gameId the unique ID of the game.
     * @return a string representing the game date in ISO format (e.g., "2024-09-06").
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getDate(int gameId) {
        final Game dateGame = nflDataBase.getGame(gameId);

        try {
            final String date = dateGame.getDate();
            if (date.contains("T")) {
                return date.split("T")[0];
            }
            return date;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the venue of the game.
     *
     * @param gameId the unique ID of the game.
     * @return a string representing the venue.
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getVenue(int gameId) {
        final Game venueGame = nflDataBase.getGame(gameId);

        try {
            final String venue = venueGame.getVenue();
            return venue;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the score of the first quarter for the game.
     *
     * @param gameId the unique ID of the game.
     * @return a string in the format "HomeQ1 - VisitorQ1".
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getq1(int gameId) {
        final Game q1Game = nflDataBase.getGame(gameId);

        try {
            final Integer homeq1 = q1Game.getHome_team_q1();
            final Integer visitorq1 = q1Game.getVisitor_team_q1();

            return homeq1 + " - " + visitorq1;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the score of the second quarter for the game.
     *
     * @param gameId the unique ID of the game.
     * @return a string in the format "HomeQ2 - VisitorQ2".
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getq2(int gameId) {
        final Game q2Game = nflDataBase.getGame(gameId);

        try {
            final Integer homeq2 = q2Game.getHome_team_q2();
            final Integer visitorq2 = q2Game.getVisitor_team_q2();

            return homeq2 + " - " + visitorq2;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the score of the third quarter for the game.
     *
     * @param gameId the unique ID of the game.
     * @return a string in the format "HomeQ3 - VisitorQ3".
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getq3(int gameId) {
        final Game q3Game = nflDataBase.getGame(gameId);

        try {
            final Integer homeq3 = q3Game.getHome_team_q3();
            final Integer visitorq3 = q3Game.getVisitor_team_q3();

            return homeq3 + " - " + visitorq3;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the score of the fourth quarter for the game.
     *
     * @param gameId the unique ID of the game.
     * @return a string in the format "HomeQ4 - VisitorQ4".
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getq4(int gameId) {
        final Game q4Game = nflDataBase.getGame(gameId);

        try {
            final Integer homeq4 = q4Game.getHome_team_q4();
            final Integer visitorq4 = q4Game.getVisitor_team_q4();

            return homeq4 + " - " + visitorq4;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the score of overtime for the game, if applicable.
     *
     * @param gameId the unique ID of the game.
     * @return a string in the format "HomeOT - VisitorOT" or "No Overtime" if no overtime occurred.
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getot(int gameId) {
        final Game otGame = nflDataBase.getGame(gameId);

        try {
            final Integer homeot = otGame.getHome_team_ot();
            final Integer visitorot = otGame.getVisitor_team_ot();

            if (homeot == 0 && visitorot == 0) {
                return "No Overtime";
            }
            return homeot + " - " + visitorot;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}

