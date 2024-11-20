package use_case.leaguestanding;

/**
 * The League Standing Interactor.
 */
public class LeagueStandingInteractor implements LeagueStandingInputBoundary {

    private final LeagueStandingOutputBoundary userPresenter;

    public LeagueStandingInteractor(LeagueStandingOutputBoundary leagueStandingOutputBoundary) {
        this.userPresenter = leagueStandingOutputBoundary;
    }

    @Override
    public void switchTeamSearchView() {
        userPresenter.switchTeamSearchView();
    }
}
