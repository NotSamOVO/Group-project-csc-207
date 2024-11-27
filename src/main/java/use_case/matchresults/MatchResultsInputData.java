package use_case.matchresults;

/**
 * The input data for the Match Results Use Case.
 */
public class MatchResultsInputData {
    private final String teamName;

    public MatchResultsInputData(String teamName) {
        this.teamName = teamName;
    }
    public String getTeamName() {
        return teamName;
    }
}
