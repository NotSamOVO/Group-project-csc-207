package use_case.teamsearch;

public class TeamSearchInputData {
    private final String teamName;

    public TeamSearchInputData(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }
}
