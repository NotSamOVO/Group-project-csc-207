package use_case.leaguestanding;

/**
 * Input boundary for the League Standing Use Case.
 */
public interface LeagueStandingInputBoundary {
    String[][] getLeagueStanding();
    String[] getTeamStanding(String teamName);
}
