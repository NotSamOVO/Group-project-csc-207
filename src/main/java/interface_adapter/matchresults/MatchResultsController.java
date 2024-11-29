package interface_adapter.matchresults;

import java.util.ArrayList;

import use_case.matchresults.MatchResultsInputData;
import use_case.matchresults.MatchResultsUseCase;

/**
 * The MatchResultsController class serves as an intermediary between the user interface and the use case logic for match results.
 * It takes the team name as input, interacts with the use case to fetch game IDs, and provides feedback on whether the game data is available.
 */
public class MatchResultsController {

    private MatchResultsUseCase matchResultsUseCase;

    /**
     * Constructs a new MatchResultsController.
     *
     * @param matchResultsUseCase the use case that handles the business logic for fetching match results
     */
    public MatchResultsController(MatchResultsUseCase matchResultsUseCase) {
        this.matchResultsUseCase = matchResultsUseCase;
    }

    /**
     * Executes the match results retrieval process based on the provided team name.
     * It fetches the game IDs from the use case and returns a boolean indicating if any results were found.
     *
     * @param teamName the name of the team whose match results are being requested
     * @return true if match results are found, false if no results are available for the given team
     */
    public boolean execute(String teamName) {
        final MatchResultsInputData inputData = new MatchResultsInputData(teamName);

        final ArrayList<Integer> gameIds = matchResultsUseCase.getGameId(inputData.getTeamName());

        if (gameIds.isEmpty()) {
            return false;
        }
        return true;
    }
}
