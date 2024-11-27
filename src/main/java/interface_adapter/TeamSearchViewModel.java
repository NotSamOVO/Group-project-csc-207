package interface_adapter;

/**
 * Model for the View Manager. Its state is the name of the View which
 * is currently active. An initial state of "" is used.
 */
public class TeamSearchViewModel extends ViewModel<String> {

    public static String SEARCH_LABEL = "Search";
    public static String TEAM_NAME_LABEL = "Please enter a team name!";
    public static String ENTER_TEAM_NAME_LABEL = "Enter Team Name:";

    public TeamSearchViewModel() {
        super("view manager");
        this.setState("");
    }

}
