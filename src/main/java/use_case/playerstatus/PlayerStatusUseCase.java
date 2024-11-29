package use_case.playerstatus;

import api.NFLTeamDataBase;

import java.util.ArrayList;

import entity.Team;
import entity.Player;

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
    public Player getPlayer(String firstName, String lastName, String teamName) {
        ArrayList<Player> allPlayers = playerDataBase.getAllPlayers();
        for (int i = 0; i < allPlayers.size(); i++) {
            Player player = allPlayers.get(i);
            String playerFirstName = player.getFirstName();
            String playerLastName = player.getLastName();
            String playerTeamName = player.getTeam().getName();

            boolean nameMatch = (playerFirstName.equals(firstName) && playerLastName.equals(lastName));
            boolean teamMatch = playerTeamName.equals(teamName);
            if (nameMatch && teamMatch) {
                return player;
            }
        }
        return null;
    }

    public String getPlayerStatus(String firstName, String lastName, String teamName) {
        Player player = getPlayer(firstName, lastName, teamName);
        if(player == null) {
            return "Player not found";
        }else {
            return player.toString();
        }
    }
}
