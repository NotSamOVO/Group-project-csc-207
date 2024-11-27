package interface_adapter;

/**
 * Model for the View Manager. Its state is the name of the View which
 * is currently active. An initial state of "" is used.
 */
public class ViewManagerModel extends ViewModel<String> {

    private static String SEARCH_LABEL = "Search";
    private static String TEAM_NAME_LABEL = "Please enter a team name!";
    private static String ENTER_TEAM_NAME_LABEL = "Enter Team Name:";

    public ViewManagerModel() {
        super("view manager");
        this.setState("");
    }

}
