package interface_adapter.leaguestanding;

import interface_adapter.ViewModel;
import interface_adapter.teamsearch.TeamSearchViewModel;
import use_case.leaguestanding.LeagueStandingOutputBoundary;

/**
 * The Presenter for the League Standing Use case.
 */
public class LeagueStandingPresenter implements LeagueStandingOutputBoundary {

    private final LeagueStandingViewModel leagueStandingViewModel;
    private final ViewModel viewModel;
    private final TeamSearchViewModel teamSearchViewModel;

    public LeagueStandingPresenter(ViewModel viewModel,
                                   LeagueStandingViewModel leagueStandingViewModel,
                                   TeamSearchViewModel teamSearchViewModel) {
        this.leagueStandingViewModel = leagueStandingViewModel;
        this.viewModel = viewModel;
        this.teamSearchViewModel = teamSearchViewModel;
    }

    @Override
    public void switchTeamSearchView() {
        viewModel.setState(teamSearchViewModel.getViewName());
        viewModel.firePropertyChanged();
    }
}
