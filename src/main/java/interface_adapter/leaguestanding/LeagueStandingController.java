package interface_adapter.leaguestanding;

import use_case.leaguestanding.LeagueStandingInputBoundary;

/**
 * Controller for handling league standing use case interactions.
 */
public class LeagueStandingController {
    private final LeagueStandingInputBoundary inputBoundary;

    public LeagueStandingController(LeagueStandingInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public String[][] getLeagueStandings() {
        return inputBoundary.getLeagueStanding();
    }

    public String[] getTeamStanding(String teamName) {
        return inputBoundary.getTeamStanding(teamName);
    }
}
