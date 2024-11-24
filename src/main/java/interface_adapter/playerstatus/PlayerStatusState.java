package interface_adapter.playerstatus;

public class PlayerStatusState {
    private String firstName = "";
    private String lastName = "";
    private String teamName = "";
    private String playerInfo = "";
    private String playerError = "";

    public PlayerStatusState(PlayerStatusState copy) {
        firstName = copy.firstName;
        lastName = copy.lastName;
        teamName = copy.teamName;
        playerInfo = copy.playerInfo;
        playerError = copy.playerError;
    }

    public PlayerStatusState() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(String playerInfo) {
        this.playerInfo = playerInfo;
    }

    public String getPlayerError() {
        return playerError;
    }

    public void setPlayerError(String playerError) {
        this.playerError = playerError;
    }
}

}
