package use_case.historicalseasons;

/**
 * Input Boundary for actions which are related to viewing Historical Seasons.
 */
public interface HistoricalSeasonsInputBoundary {
    /**
     * Executes the HistoricalSeasons use case.
     * @param inputData the input data.
     */
    void execute(HistoricalSeasonsInputData inputData);

    /**
     * Executes the switch to team search view use case.
     */
    void switchToTeamSearchView();
}
