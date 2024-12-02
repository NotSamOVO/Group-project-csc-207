package interface_adapter.leaguestanding;

import use_case.leaguestanding.LegueStandingInputData;
import use_case.leaguestanding.LeagueStandingUseCase;

/**
 * Controller for handling league standing use case interactions.
 */
public class LeagueStandingController {

    private LeagueStandingUseCase leagueStandingUseCase;

    public LeagueStandingController(LeagueStandingUseCase leagueStandingUseCase) {
        this.leagueStandingUseCase = leagueStandingUseCase;
    }

    public String[][] getLeagueStanding() {
        return leagueStandingUseCase.getLeagueStanding();
    }

    /**
     *  Getting the team standing.
     * @param teamName the team name.
     */
    public String[] getTeamStanding(String teamName) {
        final LegueStandingInputData legueStandingInputData = new LegueStandingInputData(teamName);
        return leagueStandingUseCase.getTeamStanding(legueStandingInputData.getTeamName());
    }
}
