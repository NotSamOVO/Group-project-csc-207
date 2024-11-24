package interface_adapter.historicalseasons;

import interface_adapter.ViewManagerModel;
import interface_adapter.teamsearch.TeamSearchViewModel;
import use_case.historicalseasons.HistoricalSeasonsOutputBoundary;
import use_case.historicalseasons.HistoricalSeasonsOutputData;

/**
 * The Presenter for the HistoricalSeasons Use Case.
 */
public class HistoricalSeasonsPresenter implements HistoricalSeasonsOutputBoundary {

    private final HistoricalSeasonsViewModel historicalSeasonsViewModel;
    private final TeamSearchViewModel teamSearchViewModel;
    private final ViewManagerModel viewManagerModel;

    public HistoricalSeasonsPresenter(ViewManagerModel viewManagerModel,
                                      HistoricalSeasonsViewModel historicalSeasonsViewModel,
                                      TeamSearchViewModel teamSearchViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.historicalSeasonsViewModel = historicalSeasonsViewModel;
        this.teamSearchViewModel = teamSearchViewModel;
    }

    @Override
    public void prepareTeamSearchView(HistoricalSeasonsOutputData response) {
        // Exit to Team Search view.
        viewManagerModel.setState(teamSearchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void presentHistoricalSeasons(HistoricalSeasonsOutputData outputData) {
        final HistoricalSeasonsState state = historicalSeasonsViewModel.getState();
        state.setHistoricalSeasons(outputData.getHistoricalSeasons());

        viewManagerModel.setState(historicalSeasonsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void switchToTeamSearchView() {
        viewManagerModel.setState(teamSearchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
