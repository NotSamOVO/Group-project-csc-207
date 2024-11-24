package use_case.playerstatus;

/**
 * DAO for the PlayerStatus Use Case.
 */
public interface PlayerStatusDataAccessInteractor {

    /**
     * Checks if the given player name exists.
     * @param firstName the firstname to look for
     * @param lastName the lastName to look for
     * @param team the team name to look for
     * @return true if a player with the given username exists; false otherwise
     */
    boolean existsByName(String firstName, String lastName, String team);
}
