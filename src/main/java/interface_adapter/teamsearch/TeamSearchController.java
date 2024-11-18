package interface_adapter.teamsearch;

/**
 * Controller for the Team Search Use Case.
 */
public class TeamSearchController {

    private final TeamSearchViewModel teamSearchViewModel;

    public TeamSearchController(TeamSearchViewModel teamSearchViewModel) {
        this.teamSearchViewModel = teamSearchViewModel;
    }

    /**
     * Executes the Team Search Use Case.
     * @param teamId the ID of the team to search for.
     */
    public void executeSearch(String teamId) {
        // To be implemented
        teamSearchViewModel.getState().setTeamId(teamId);
    }
}
