package interface_adapter.team_search;

import use_case.teamsearch.TeamSearchInputData;
import use_case.teamsearch.TeamSearchUseCase;

public class TeamSearchController {
    TeamSearchUseCase teamSearchUseCase;

    public TeamSearchController(TeamSearchUseCase teamSearchUseCase) {
        this.teamSearchUseCase = teamSearchUseCase;
    }

    public boolean searchTeam(String teamName) {
        String result = teamSearchUseCase.getTeamId(teamName);
        TeamSearchInputData inputData = new TeamSearchInputData(result);

        if (inputData.getTeamName().equals("Team Not Found")) {
            return false;
        }
        return true;
    }
}
