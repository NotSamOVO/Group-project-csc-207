package interface_adapter.teamsearch;

import use_case.teamsearch.TeamSearchInputBoundary;

/**
 * Controller for the Team Search Use Case.
 */
public class TeamSearchController {

    private final TeamSearchViewModel teamSearchViewModel;
    private final TeamSearchInputBoundary userTeamsearchUseCaseInteractor;

    public TeamSearchController(TeamSearchViewModel teamSearchViewModel,
                                TeamSearchInputBoundary userTeamsearchUseCaseInteractor) {
        this.teamSearchViewModel = teamSearchViewModel;
        this.userTeamsearchUseCaseInteractor = userTeamsearchUseCaseInteractor;
    }

    /**
     * Executes the Team Search Use Case.
     * @param teamId the ID of the team to search for.
     */
    public void executeSearch(String teamId) {
        // To be implemented
        teamSearchViewModel.getState().setTeamId(teamId);
    }

    /**
     * Executes the "switch to LeagueStandingView" Use Case.
     */
    public void switchLeagueStandingView() {
        userTeamsearchUseCaseInteractor.switchLeagueStandingView();
    }

    /**
     * Executes the "switch to HistoricalSeasonsView" Use Case.
     */
    public void switchHistoricalSeasonsView() { userTeamsearchUseCaseInteractor.switchHistoricalSeasonsView(); }
}
