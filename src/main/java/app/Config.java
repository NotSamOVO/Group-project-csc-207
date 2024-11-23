package app;

import api.NFLTeamDataBase;
import api.NFLDataBase;
import use_case.matchresults.MatchResultsUseCase;
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
     * Get the MatchResults object.
     * @return MatchResults object.
     */
    public MatchResultsUseCase getMatchResultsUseCase() {
        return new MatchResultsUseCase(dataBase);
    }
}
