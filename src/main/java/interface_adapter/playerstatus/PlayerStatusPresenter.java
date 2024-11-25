package interface_adapter.playerstatus;

import interface_adapter.ViewModel;
import interface_adapter.teamsearch.TeamSearchViewModel;
import use_case.playerstatus.PlayerStatusOutputBoundary;
import use_case.playerstatus.PlayerStatusOutputData;

/**
 * The Presenter for the Player Status Use case.
 */
public class PlayerStatusPresenter implements PlayerStatusOutputBoundary {

    private final PlayerStatusViewModel playerStatusViewModel;
    private final ViewModel viewModel;
    private final TeamSearchViewModel teamSearchViewModel;

    public PlayerStatusPresenter(ViewModel viewModel,
                                 PlayerStatusViewModel playerStatusViewModel,
                                 TeamSearchViewModel teamSearchViewModel) {
        this.playerStatusViewModel = playerStatusViewModel;
        this.viewModel = viewModel;
        this.teamSearchViewModel = teamSearchViewModel;
    }

    @Override
    public void presentPlayerStatus(PlayerStatusOutputData playerData) {
        PlayerStatusState playerStatusState = playerStatusViewModel.getState();
        playerStatusState.setPlayerInfo(formatPlayerInfo(playerData));
        this.playerStatusViewModel.setState(playerStatusState);
        this.playerStatusViewModel.firePropertyChanged();

        viewModel.setState(playerStatusViewModel.getViewName());
        viewModel.firePropertyChanged();
    }

    @Override
    public void presentPlayerNotFound(String errorMessage) {
        PlayerStatusState playerStatusState = playerStatusViewModel.getState();
        playerStatusState.setErrorMessage(errorMessage);
        this.playerStatusViewModel.setState(playerStatusState);
        this.playerStatusViewModel.firePropertyChanged();
    }

    @Override
    public void switchToTeamSearchView() {
        viewModel.setState(teamSearchViewModel.getViewName());
        viewModel.firePropertyChanged();
    }

    private String formatPlayerInfo(PlayerStatusOutputData playerData) {
        return String.format("Name: %s %s\nPosition: %s\nTeam: %s\nJersey: %s\nHeight: %s\nWeight: %s\nAge: %d\nExperience: %s\nCollege: %s",
                playerData.getFirstName(), playerData.getLastName(),
                playerData.getPosition(),
                playerData.getTeamName(),
                playerData.getJerseyNumber(),
                playerData.getHeight(),
                playerData.getWeight(),
                playerData.getAge(),
                playerData.getExperience(),
                playerData.getCollege());
    }
}