package interface_adapter.leaguestanding;

import use_case.leaguestanding.LeagueStandingInputBoundary;

/**
 * Controller for the Legue Standing Use Case.
 */
public class LeagueStandingController {

    private final LeagueStandingInputBoundary userLegueStandingUseCaseInteractor;

    public LeagueStandingController(LeagueStandingInputBoundary userLegueStandingUseCaseInteractor) {
        this.userLegueStandingUseCaseInteractor = userLegueStandingUseCaseInteractor;
    }

    /**
     * Executes the "switch to TeamSearchView" Use Case.
     */
    public void switchTeamSearchView() {
        userLegueStandingUseCaseInteractor.switchTeamSearchView();
    }
}
