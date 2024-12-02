package interface_adapter.leaguestanding;

import use_case.leaguestanding.LeagueStandingOutputBoundary;

/**
 * Presenter for formatting league standings.
 */
public class LeagueStandingPresenter implements LeagueStandingOutputBoundary {

    @Override
    public String[][] presentLeagueStandings(String[][] standings) {
        return standings;
    }

    @Override
    public String[] presentTeamStanding(String[] teamStanding) {
        return teamStanding;
    }
}
