package interface_adapter.leaguestanding;

import interface_adapter.ViewModel;

/**
 * The View Model for the League Standing View.
 */
public class LeagueStandingViewModel extends ViewModel<LeagueStandingState> {

    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public LeagueStandingViewModel() {
        super("League Standing");
        setState(new LeagueStandingState());
    }

}
