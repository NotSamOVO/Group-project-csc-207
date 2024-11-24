package use_case.playerstatus;

/**
 * The Input Data for the PlayerStatus Use Case.
 */
public class PlayerStatusInputData {
    private String firstName;
    private String lastName;
    private int teamName;

    public PlayerStatusInputData(String firstName, String lastName, int teamName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamName = teamName;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    int getTeamName() {
        return teamName;
    }
}
