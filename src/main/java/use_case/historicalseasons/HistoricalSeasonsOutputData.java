package use_case.historicalseasons;

import java.util.ArrayList;

import entity.Season;

/**
 * The Output data for the HistoricalSeasons Use Case.
 */
public class HistoricalSeasonsOutputData {
    private final ArrayList<Season> historicalSeasons;

    public HistoricalSeasonsOutputData(ArrayList<Season> historicalSeasons) {
        this.historicalSeasons = historicalSeasons;
    }

    public ArrayList<Season> getHistoricalSeasons() {
        return historicalSeasons;
    }
}
