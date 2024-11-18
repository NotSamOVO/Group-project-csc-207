package interface_adapter.teamsearch;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Team search View.
 */
public class TeamsearchViewModel extends ViewModel<SignupState> {

    public static final String TEAMSEARCH_LABEL = "Team Search(ID)";

    public static final String LEAGUE_STANDING_BUTTON_LABEL = "League Standing";
    public static final String MATCH_RESULTS_BUTTON_LABEL = "Match Results";
    public static final String PLAYER_STATS_BUTTON_LABEL = "Player Stats";
    public static final String HISTORICAL_SEANSONS_BUTTON_LABEL = "Historical Seasons";

    public TeamsearchViewModel() {
        super("team search");
        setState(new SignupState());
    }

}
