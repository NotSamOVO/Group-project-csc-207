package interface_adapter.team_search;

import interface_adapter.ViewModel;
import use_case.teamsearch.TeamSearchOutputData;
import use_case.teamsearch.TeamSearchUseCase;

/**
 * Model for the View Manager. Its state is the name of the View which
 * is currently active. An initial state of "" is used.
 */
public class TeamSearchViewModel {

    public static String SEARCH_LABEL = "Search";
    public static String TEAM_NAME_LABEL = "Please enter a team name!";
    public static String ENTER_TEAM_NAME_LABEL = "Enter Team Name:";

    private final TeamSearchUseCase teamSearchUseCase;

    public TeamSearchViewModel(TeamSearchUseCase teamSearchUseCase) {
        this.teamSearchUseCase = teamSearchUseCase;
    }

    public TeamSearchOutputData searchTeam(String teamName) {
        final String result = teamSearchUseCase.getTeamId(teamName);

        final TeamSearchOutputData outputData = new TeamSearchOutputData(result);
        return outputData;
    }
}
