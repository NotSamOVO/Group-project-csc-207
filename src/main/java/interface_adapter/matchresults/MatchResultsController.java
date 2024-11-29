package interface_adapter.matchresults;

import use_case.matchresults.MatchResultsInputData;

public class MatchResultsController {
    private final MatchResultsInputData userMatchResults;

    public MatchResultsController(MatchResultsInputData userMatchResults) {
        this.userMatchResults = userMatchResults;
    }

    public String execute(String teamName) {
        return userMatchResults.getTeamName();
    }
}
