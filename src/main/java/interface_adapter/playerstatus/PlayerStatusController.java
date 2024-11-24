package interface_adapter.playerstatus;

import use_case.playerstatus.PlayerStatusInputBoundary;
import use_case.playerstatus.PlayerStatusInputData;

public class PlayerStatusController {

    final PlayerStatusInputBoundary playerStatusUseCaseInteractor;

    public PlayerStatusController(PlayerStatusInputBoundary playerStatusUseCaseInteractor) {
        this.playerStatusUseCaseInteractor = playerStatusUseCaseInteractor;
    }

    public void executePlayerStatus(String firstName, String lastName, String teamName) {
        PlayerStatusInputData playerStatusInputData = new PlayerStatusInputData(
                firstName, lastName, teamName);

        playerStatusUseCaseInteractor.execute(playerStatusInputData);
    }

    public void switchToTeamSearchView() {
        playerStatusUseCaseInteractor.switchToTeamSearchView();
    }
}
