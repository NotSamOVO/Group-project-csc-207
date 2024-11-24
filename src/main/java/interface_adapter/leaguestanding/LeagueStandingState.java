package interface_adapter.leaguestanding;

/**
 * The state for the Leaguestanding View Model.
 */
public class LeagueStandingState {

    private String[][] leaguestanding;
    private String teamError;

    public String[][] getLeaguestanding() {
        return leaguestanding;
    }

    public void setLeaguestanding(String[][] leaguestanding) {
        this.leaguestanding = leaguestanding;
    }

    public String getTeamError() {
        return teamError;
    }

    public void setTeamError(String teamError) {
        this.teamError = teamError;
    }
}
