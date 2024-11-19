package use_case;

import api.NFLTeamDataBase;
import org.json.JSONArray;
import org.json.JSONObject;

public class TeamSearchUseCase {
    private NFLTeamDataBase teamDatabase = new NFLTeamDataBase();

    public TeamSearchUseCase(NFLTeamDataBase dataBase) {
        this.teamDatabase = dataBase;
    }

    /**
     * get the team id by inputting team name
     * @param teamName The name of the team.
     * @return the id of the team. -1 if the team is not found.
     */
    public int getTeamId(String teamName) {
        JSONArray allTeams = teamDatabase.getAllTeams();
        for (int i = 0; i < allTeams.length(); i++) {
            JSONObject team = allTeams.getJSONObject(i);
            if (team.getString("name").equals(teamName)) {
                return team.getInt("id");
            }
        }
        return -1;
    }
}
