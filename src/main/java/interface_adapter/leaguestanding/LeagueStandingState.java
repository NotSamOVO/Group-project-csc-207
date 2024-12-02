package interface_adapter.leaguestanding;

/**
 * The state for the Leaguestanding View Model.
 */
public class LeagueStandingState {

    private String[][] leaguestanding;
    private String[] teamstanding;

    public String[][] getLeaguestanding() {
        return leaguestanding;
    }

    public String[] getTeamStanding() {
        return teamstanding;
    }

    public void setTeamstanding(String[] teamstanding) {
        this.teamstanding = teamstanding;
    }

    public void setLeaguestanding(String[][] leaguestanding) {
        this.leaguestanding = leaguestanding;
    }

}
