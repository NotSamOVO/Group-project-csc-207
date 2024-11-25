package use_case.playerstatus;

/**
 * The output boundary for the PlayerStatus Use Case.
 */
public interface PlayerStatusOutputBoundary {

    void presentPlayerStatus(PlayerStatusOutputData outputData);

    void presentPlayerNotFound(String errorMessage);

    /**
     * Switches to the Teamsearch View.
     */
    void switchToTeamSearchView();
}
