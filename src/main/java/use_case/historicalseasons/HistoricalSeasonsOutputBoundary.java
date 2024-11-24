package use_case.historicalseasons;

/**
 * The output boundary for the HistoricalSeasons Use Case.
 */
public interface HistoricalSeasonsOutputBoundary {

    void prepareTeamSearchView(HistoricalSeasonsOutputData response);

    /**
     * Presents the view for the HistoricalSeasons Use Case.
     * @param outputData the output data.
     */
    void presentHistoricalSeasons(HistoricalSeasonsOutputData outputData);

    /**
     * Switches to the Team Search View.
     */
    void switchToTeamSearchView();
}