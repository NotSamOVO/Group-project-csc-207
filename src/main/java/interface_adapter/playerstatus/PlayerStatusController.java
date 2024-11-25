package interface_adapter.playerstatus;

import use_case.playerstatus.PlayerStatusInputBoundary;

public class PlayerStatusController {

    final PlayerStatusInputBoundary playerStatusUseCaseInteractor;

    public PlayerStatusController(PlayerStatusInputBoundary playerStatusUseCaseInteractor) {
        this.playerStatusUseCaseInteractor = playerStatusUseCaseInteractor;
    }

    public void switchToTeamSearchView() {
        playerStatusUseCaseInteractor.switchToTeamSearchView();
    }
}
