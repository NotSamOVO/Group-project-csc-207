package use_case.teamsearch;

/**
 * The Team Search Interactor.
 */
public class TeamSearchInteractor implements TeamSearchInputBoundary {

    private final TeamSearchOutputBoundary userPresenter;

    public TeamSearchInteractor(TeamSearchOutputBoundary teamSearchOutputBoundary) {
        this.userPresenter = teamSearchOutputBoundary;
    }

    @Override
    public void switchLeagueStandingView() {
        userPresenter.switchLeagueStandingView();
    }
}
