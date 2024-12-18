package interface_adapter.teamsearch;

import interface_adapter.ViewModel;
import interface_adapter.leaguestanding.LeagueStandingViewModel;
import use_case.teamsearch.TeamSearchOutputBoundary;

/**
 * The Presenter for the Team Search Use case.
 */
public class TeamSearchPresenter implements TeamSearchOutputBoundary {

    private final LeagueStandingViewModel leagueStandingViewModel;
    private final ViewModel viewModel;
    private final TeamSearchViewModel teamSearchViewModel;

    public TeamSearchPresenter(ViewModel viewModel,
                                   LeagueStandingViewModel leagueStandingViewModel,
                                   TeamSearchViewModel teamSearchViewModel) {
        this.leagueStandingViewModel = leagueStandingViewModel;
        this.viewModel = viewModel;
        this.teamSearchViewModel = teamSearchViewModel;
    }

    @Override
    public void switchLeagueStandingView() {
        viewModel.setState(leagueStandingViewModel.getViewName());
        viewModel.firePropertyChanged();
    }
}
