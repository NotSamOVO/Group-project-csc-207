package use_case.leaguestanding;

/**
 * Output boundary for presenting league standings.
 */
public interface LeagueStandingOutputBoundary {
    String[][] presentLeagueStandings(String[][] standings);
    String[] presentTeamStanding(String[] teamStanding);
}
