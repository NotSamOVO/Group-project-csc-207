package use_case.teamsearch;

import api.NFLTeamDataBase;
import org.json.JSONArray;
import org.json.JSONObject;

import entity.Team;
import entity.Player;

import java.util.ArrayList;

public class TeamSearchUseCase {
    private NFLTeamDataBase teamDatabase = new NFLTeamDataBase();

    public TeamSearchUseCase(NFLTeamDataBase dataBase) {
        this.teamDatabase = dataBase;
    }

    /**
     * get the team id by inputting team name.
     * @param teamName The name of the team.
     * @return the id of the team. -1 if the team is not found.
     */
    public String getTeamId(String teamName) {
        ArrayList<Team> allTeams = teamDatabase.getAllTeams();
        for (int i = 0; i < allTeams.size(); i++) {
            Team team = allTeams.get(i);
            if (team.getName().equals(teamName)) {
                return team.toString();
            }
        }
        return "Team Not Found";
    }
}
