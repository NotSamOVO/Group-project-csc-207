package use_case.playerstatus;

/**
 * The player status interactor
 */
public class PlayerStatusInteractor implements PlayerStatusInputBoundary{
    private final PlayerStatusOutputBoundary userPresenter;

    public PlayerStatusInteractor(PlayerStatusOutputBoundary userPresenter) {
        this.userPresenter = userPresenter;
    }

    @Override
    public void switchToTeamSearchView() {
        userPresenter.switchToTeamSearchView();
    }

}
