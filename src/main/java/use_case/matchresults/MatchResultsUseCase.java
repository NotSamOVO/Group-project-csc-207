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
 * The MatchresultsOutputData class provides methods to retrieve and process
 * data related to NFL games, including game descriptions, scores, and dates.
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
     * Retrieves a formatted string representing the game matchup.
     *
     * @return a list of gameId.
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public ArrayList<Integer> getGameId(String teamName) {
        final ArrayList<Game> allGames = nflDataBase.getAllGames();
        final ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < allGames.size(); i++) {
            final Game game = allGames.get(i);
            final Integer gameId = game.getId();
            final Team homeTeamObj = game.getHome_team();
            final Team visitorTeamObj = game.getVisitor_team();
            final String homeTeam = homeTeamObj.getName();
            final String visitorTeam = visitorTeamObj.getName();
            if (homeTeam.equals(teamName) || visitorTeam.equals(teamName)) {
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
     * @return a string representing the game date in ISO format (e.g., "2024-09-06T00:20:00.000Z").
     * @throws RuntimeException if the game data is malformed or missing.
     */
    public String getDate(int gameId) {
        final Game dateGame = nflDataBase.getGame(gameId);

        try {
            final String date = dateGame.getDate();
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

    public String getq1(int gameId) {
        final Game q1Game = nflDataBase.getGame(gameId);

        try {
            Integer homeq1 = q1Game.getHome_team_q1();
            Integer visitorq1 = q1Game.getVisitor_team_q1();
            if (homeq1 == null) {
                homeq1 = 0;
            }
            if (visitorq1 == null) {
                visitorq1 = 0;
            }
            return homeq1 + " - " + visitorq1;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getq2(int gameId) {
        final Game q2Game = nflDataBase.getGame(gameId);

        try {
            Integer homeq2 = q2Game.getHome_team_q2();
            Integer visitorq2 = q2Game.getVisitor_team_q2();
            if (homeq2 == null) {
                homeq2 = 0;
            }
            if (visitorq2 == null) {
                visitorq2 = 0;
            }
            return homeq2 + " - " + visitorq2;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getq3(int gameId) {
        final Game q3Game = nflDataBase.getGame(gameId);

        try {
            Integer homeq3 = q3Game.getHome_team_q3();
            Integer visitorq3 = q3Game.getVisitor_team_q3();
            if (homeq3 == null) {
                homeq3 = 0;
            }
            if (visitorq3 == null) {
                visitorq3 = 0;
            }
            return homeq3 + " - " + visitorq3;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String getq4(int gameId) {
        final Game q4Game = nflDataBase.getGame(gameId);

        try {
            Integer homeq4 = q4Game.getHome_team_q4();
            Integer visitorq4 = q4Game.getVisitor_team_q4();
            if (homeq4 == null) {
                homeq4 = 0;
            }
            if (visitorq4 == null) {
                visitorq4 = 0;
            }
            return homeq4 + " - " + visitorq4;
        }
        catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
