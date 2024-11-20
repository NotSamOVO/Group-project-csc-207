package use_case;

import api.NFLTeamDataBase;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlayerStatusUseCase {
    private NFLTeamDataBase playerDataBase = new NFLTeamDataBase();

    public PlayerStatusUseCase(NFLTeamDataBase playerDataBase) {
        this.playerDataBase = playerDataBase;
    }

    /**
     * get the team id by inputting team name
     * @param firstName The first name of the player.
     * @param lastName The last name of the player.
     * @param teamName The team name of the player.
     * @return the id of the player. -1 if the player is not found.
     */
    public int getPlayerId(String firstName, String lastName, String teamName) {
        JSONArray allPlayers = playerDataBase.getAllPlayers();
        for (int i = 0; i < allPlayers.length(); i++) {
            JSONObject player = allPlayers.getJSONObject(i);
            String playerFirstName = player.getString("first_name").toLowerCase();
            String playerLastName = player.getString("last_name").toLowerCase();
            String playerTeamName = player.getJSONObject("team").getString("full_name").toLowerCase();

            boolean nameMatch = (playerFirstName.equals(firstName) && playerLastName.equals(lastName)) ||
                    (playerLastName.equals(firstName) && playerFirstName.equals(lastName));
            boolean teamMatch = teamName.isEmpty() || playerTeamName.contains(teamName);

            if (nameMatch && teamMatch) {
                return player.getInt("id");
            }
        }
        return -1;
    }
}
