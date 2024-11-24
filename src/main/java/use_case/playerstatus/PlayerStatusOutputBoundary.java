package use_case.playerstatus;

/**
 * The output boundary for the PlayerStatus Use Case.
 */
public interface PlayerStatusOutputBoundary {

    /**
     * Prepares the failure view for the PlayerStatus Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the playerStatus View.
     */
    void switchPlayerStatusView();
}
