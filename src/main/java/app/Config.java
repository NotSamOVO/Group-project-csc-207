package app;

import api.NFLTeamDataBase;
import api.NFLDataBase;
import use_case.PlayerStatusUseCase;
import use_case.teamsearch.TeamSearchUseCase;

public class Config {
    private final NFLTeamDataBase dataBase = new NFLTeamDataBase();

    /**
     * Get the TeamSearchUseCase object.
     * @return TeamSearchUseCase object.
     */
    public TeamSearchUseCase getTeamSearchUseCase() {
        return new TeamSearchUseCase(dataBase);
    }

    /**
     * Get the TeamSearchUseCase object.
     * @return TeamSearchUseCase object.
     */
    public PlayerStatusUseCase getPlayerStatusUseCase() {
        return new PlayerStatusUseCase(dataBase);
    }
}
