package use_case.teamsearch;

import api.NFLDataBase;
import api.NFLTeamDataBase;
import org.json.JSONArray;
import org.json.JSONObject;

import entity.Team;
import entity.Player;

import java.util.ArrayList;

public class TeamSearchUseCase {
    private NFLDataBase dataBase;

    public TeamSearchUseCase(NFLDataBase dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * get the team id by inputting team name.
     * @param teamName The name of the team.
     * @return "Team Not Found" if the team is not found.
     */
    public String getTeamId(String teamName) {
        ArrayList<Team> allTeams = dataBase.getAllTeams();
        for (int i = 0; i < allTeams.size(); i++) {
            Team team = allTeams.get(i);
            if (team.getName().equals(teamName)) {
                return team.toString();
            }
        }
        return "Team Not Found";
    }
}
