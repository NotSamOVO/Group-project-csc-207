package use_case.teamsearch;

import api.NFLDataBase;
import entity.Team;
import java.util.ArrayList;

/**
 * This class handles the use case of searching for a team in the NFL database.
 * It allows retrieving a team's details based on its name.
 */
public class TeamSearchUseCase {
    private NFLDataBase dataBase;

    /**
     * Constructs a TeamSearchUseCase object with the specified NFL database.
     *
     * @param dataBase The NFL database that contains the teams' data.
     */
    public TeamSearchUseCase(NFLDataBase dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * Retrieves the team details (in string format) by inputting the team name.
     * Searches through the list of all teams in the database and returns the team details
     * if the team is found. If no team is found with the given name, returns a "Team Not Found" message.
     *
     * @param teamName The name of the team to search for.
     * @return A string representation of the team if found, or "Team Not Found" if the team does not exist.
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
