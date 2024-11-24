package interface_adapter.historicalseasons;

import use_case.historicalseasons.HistoricalSeasonsInputBoundary;
import use_case.historicalseasons.HistoricalSeasonsInputData;

/**
 * Controller for the Historical Seasons Use Case.
 */
public class HistoricalSeasonsController {

    private final HistoricalSeasonsInputBoundary historicalSeasonsUseCaseInteractor;

    public HistoricalSeasonsController(HistoricalSeasonsInputBoundary historicalSeasonsUseCaseInteractor) {
        this.historicalSeasonsUseCaseInteractor = historicalSeasonsUseCaseInteractor;
    }

    /**
     * Executes the HistoricalSeasons Use Case.
     * @param teamId the ID of the team.
     */
    public void execute(int teamId) {
        final HistoricalSeasonsInputData historicalSeasonsInputData = new HistoricalSeasonsInputData(teamId);

        historicalSeasonsUseCaseInteractor.execute(historicalSeasonsInputData);
    }

    /**
     * Executes the "switch to TeamSearch" Use Case.
     */
    public void switchToTeamSearchView() {
        historicalSeasonsUseCaseInteractor.switchToTeamSearchView();
    }
}
