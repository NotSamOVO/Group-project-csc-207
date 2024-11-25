package interface_adapter.playerstatus;

import interface_adapter.ViewModel;

public class PlayerStatusViewModel extends ViewModel<PlayerStatusState>{
    public static final String TITLE_LABEL = "Player Status";
    public static final String FIRST_NAME_LABEL = "First Name:";
    public static final String LAST_NAME_LABEL = "Last Name:";
    public static final String TEAM_NAME_LABEL = "Team Name:";
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String BACK_BUTTON_LABEL = "Back";

    public PlayerStatusViewModel() {
        super("Player Status");
        setState(new PlayerStatusState());
    }
}
