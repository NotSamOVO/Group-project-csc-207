package use_case.historicalseasons;

/**
 * The output boundary for the HistoricalSeasons Use Case.
 */
public interface HistoricalSeasonsOutputBoundary {

    /**
     * Presents the view for the HistoricalSeasons Use Case.
     * @param outputData the output data.
     */
    void presentHistoricalSeasons(HistoricalSeasonsOutputBoundary outputData);

    /**
     * Switches to the Team Search View.
     */
    void switchToTeamSearchView();
}
