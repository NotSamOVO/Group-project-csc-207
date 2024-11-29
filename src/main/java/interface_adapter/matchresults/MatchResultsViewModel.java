package interface_adapter.matchresults;

import java.util.ArrayList;

import use_case.matchresults.MatchResultsOutputData;
import use_case.matchresults.MatchResultsUseCase;

/**
 * The ViewModel for Match Results that interacts with the use case to fetch game information.
 * This class formats and provides the necessary data to be displayed in the UI.
 */
public class MatchResultsViewModel {
    public static final String TEAM_NAME_LABEL = "Enter Team Name:";
    public static final String NO_RESULTS_LABEL = "Results will appear here...";
    public static final String GAME_LABEL = "Game";
    public static final String SCORES_LABEL = "Results";
    public static final String DATE_LABEL = "Date";
    public static final String Q1_LABEL = "Q1";
    public static final String Q2_LABEL = "Q2";
    public static final String Q3_LABEL = "Q3";
    public static final String Q4_LABEL = "Q4";
    public static final String OT_LABEL = "OT";
    public static final String VENUE_LABEL = "Venue";

    public static final String SUBMIT_BUTTON_LABEL = "Submit";

    private final MatchResultsUseCase matchResultsUseCase;

    public MatchResultsViewModel(MatchResultsUseCase matchResultsUseCase) {
        this.matchResultsUseCase = matchResultsUseCase;
    }

    /**
     * Retrieves a list of game IDs for a given team name.
     * This method communicates with the use case to fetch relevant game data.
     *
     * @param teamName the name of the team to search for
     * @return a list of game IDs associated with the given team
     */
    public ArrayList<Integer> getGameIds(String teamName) {
        final ArrayList<Integer> gameIds = matchResultsUseCase.getGameId(teamName);
        return gameIds;
    }

    /**
     * Retrieves the details of a game based on its unique game ID.
     * This method uses the use case to fetch the details of the game and formats them into a response.
     *
     * @param gameId the unique identifier for the game
     * @return a MatchResultsOutputData object containing the game's details such as matchup, score, date, etc.
     */
    public MatchResultsOutputData getGameDetails(int gameId) {
        final String matchup = matchResultsUseCase.getGame(gameId);
        final String score = matchResultsUseCase.getScore(gameId);
        final String date = matchResultsUseCase.getDate(gameId);
        final String q1 = matchResultsUseCase.getq1(gameId);
        final String q2 = matchResultsUseCase.getq2(gameId);
        final String q3 = matchResultsUseCase.getq3(gameId);
        final String q4 = matchResultsUseCase.getq4(gameId);
        final String ot = matchResultsUseCase.getot(gameId);
        final String venue = matchResultsUseCase.getVenue(gameId);

        final MatchResultsOutputData outputData = new MatchResultsOutputData(matchup, score, date, q1, q2, q3, q4, ot,
                venue);
        return outputData;
    }
}
