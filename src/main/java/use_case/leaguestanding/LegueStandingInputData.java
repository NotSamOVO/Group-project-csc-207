package use_case.leaguestanding;

/**
 * The Input Data for the League Standing Use Case.
 */
public class LegueStandingInputData {
    private final String teamName;

    public LegueStandingInputData(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }
}
