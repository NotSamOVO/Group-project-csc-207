package use_case.playerstatus;

import entity.Player;
/**
 * DAO for the PlayerStatus Use Case.
 */
public interface PlayerStatusDataAccessInteractor {
    Player findPlayer(String firstName, String lastName, String teamName);
}
