package use_case.playerstatus;

import entity.Player;

/**
 * The player status interactor
 */
public class PlayerStatusInteractor {
    private final PlayerStatusDataAccessInteractor dataAccessObject;
    private final PlayerStatusOutputBoundary userPresenter;
    private final Player player;

    public PlayerStatusInteractor(PlayerStatusDataAccessInteractor dataAccessObject
            ,PlayerStatusOutputBoundary userPresenter, Player player) {
        this.dataAccessObject = dataAccessObject;
        this.userPresenter = userPresenter;
        this.player = player;
    }

    @Override
    public void execute(PlayerStatusInputData playerStatusInputData){
        String firstName = playerStatusInputData.getFirstName();
        String lastName = playerStatusInputData.getLastName();
        String teamName = playerStatusInputData.getTeamName();
        if(!dataAccessObject.existsByName(firstName, lastName, teamName)){
            userPresenter.prepareFailView("Player not found");
        }
    }

    @Override
    public void switchToPlayerStatusView(){
        userPresenter.switchPlayerStatusView();
    }

}
