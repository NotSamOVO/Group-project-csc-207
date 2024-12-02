package use_case.leaguestanding;

public class LeagueStandingOutputData {
    private final String[] teamStandings;
    public LeagueStandingOutputData(String[] teamStandings) {
        this.teamStandings = teamStandings;
    }
    public String[] getTeamStandings() {
        return teamStandings;
    }
}
