package use_case.playerstatus;

/**
 * Input Boundary for actions which are related to getting player status.
 */
public interface PlayerStatusInputBoundary {
    /**
     * Executes the playerstatus use case.
     * @param playerStatusData the input data
     */
    void execute(PlayerStatusInputData playerStatusData);

    /**
     * Executes the switch to player view use case.
     */
    void switchToPlayerView();
}
