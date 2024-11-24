package interface_adapter.historicalseasons;

import entity.Season;

import java.util.ArrayList;

public class HistoricalSeasonsState {
    private int teamId = 1;
    private ArrayList<Season> historicalSeasons = new ArrayList<>();

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public ArrayList<Season> getHistoricalSeasons() {
        return historicalSeasons;
    }

    public void setHistoricalSeasons(ArrayList<Season> historicalSeasons) {
        this.historicalSeasons = historicalSeasons;
    }
}
