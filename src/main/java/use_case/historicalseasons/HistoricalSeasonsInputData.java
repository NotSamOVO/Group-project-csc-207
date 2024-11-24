package use_case.historicalseasons;

/**
 * The Input Data for the Historical Seasons Use Case.
 */
public class HistoricalSeasonsInputData {

    private final int teamId;

    public HistoricalSeasonsInputData(int teamId) {
        this.teamId = teamId;
    }

    int getTeamId() {
        return teamId;
    }
}
