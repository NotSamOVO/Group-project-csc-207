package use_case.historicalseasons;

import java.util.ArrayList;

import api.NFLDataBase;
import entity.Season;

/**
 * The Historical Seasons Interactor.
 */
public class HistoricalSeasonsInteractor implements HistoricalSeasonsInputBoundary {
    private final HistoricalSeasonsOutputBoundary outputBoundary;
    private final NFLDataBase database;

    public HistoricalSeasonsInteractor(HistoricalSeasonsOutputBoundary outputBoundary, NFLDataBase database) {
        this.outputBoundary = outputBoundary;
        this.database = database;
    }

    @Override
    public void execute(HistoricalSeasonsInputData inputData) {
        final int teamId = inputData.getTeamId();
        final ArrayList<Season> historicalSeasons = database.getTeamHistoricalSeasons(teamId, 5);
        final HistoricalSeasonsOutputData outputData = new HistoricalSeasonsOutputData(historicalSeasons);
        outputBoundary.presentHistoricalSeasons(outputData);
    }

    @Override
    public void switchToTeamSearchView() {
        outputBoundary.switchToTeamSearchView();
    }
}
