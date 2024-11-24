package interface_adapter.historicalseasons;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the HistoricalSeasons View.
 */
public class HistoricalSeasonsViewModel extends ViewModel<HistoricalSeasonsState> {

    public static final String TITLE_LABEL = "Historical Seasons View";

    public HistoricalSeasonsViewModel() {
        super("Historical Seasons View");
        setState(new HistoricalSeasonsState());
    }
}
