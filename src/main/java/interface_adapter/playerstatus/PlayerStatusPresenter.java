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
    public void switchToTeamSearchView() {
        viewModel.setState(teamSearchViewModel.getViewName());
        viewModel.firePropertyChanged();
    }
}