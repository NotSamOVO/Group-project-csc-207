package use_case.playerstatus;

import entity.Player;

/**
 * The player status interactor
 */
public class PlayerStatusInteractor {
    private final PlayerStatusOutputBoundary playerStatusPresenter;
    private final PlayerDataAccessInterface playerDataAccessObject;

    public PlayerStatusInteractor(PlayerStatusOutputBoundary playerStatusPresenter,
                                  PlayerDataAccessInterface playerDataAccessObject) {
        this.playerStatusPresenter = playerStatusPresenter;
        this.playerDataAccessObject = playerDataAccessObject;
    }

    @Override
    public void execute(PlayerStatusInputData playerStatusInputData){
        Player player = playerDataAccessObject.findPlayer(inputData.getFirstName(), inputData.getLastName(), inputData.getTeamName());

        if (player != null) {
            PlayerStatusOutputData outputData = new PlayerStatusOutputData(
                    player.getId(),
                    player.getFirstName(),
                    player.getLastName(),
                    player.getPosition(),
                    player.getPositionAbbreviation(),
                    player.getHeight(),
                    player.getWeight(),
                    player.getJerseyNumber(),
                    player.getCollege(),
                    player.getExperience(),
                    player.getAge(),
                    player.getTeam().getName(),
                    player.getTeam().getAbbreviation()
            );
            playerStatusPresenter.presentPlayerStatus(outputData);
        } else {
            playerStatusPresenter.presentPlayerNotFound("Player not found");
        }
    }

    @Override
    public void switchToPlayerStatusView(){
        userPresenter.switchPlayerStatusView();
    }

}
