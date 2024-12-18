package app;

import api.NFLTeamDataBase;
import use_case.leaguestanding.LeagueStandingUseCase;
import use_case.matchresults.MatchResultsUseCase;
import use_case.playerstatus.PlayerStatusUseCase;
import use_case.teamsearch.TeamSearchUseCase;

/**
 * The Config class is responsible for creating and providing access to various use case objects.
 * Each method in this class returns a new instance of a use case that interacts with the NFLTeamDataBase.
 */
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

    /**
     * Get the TeamSearchUseCase object.
     * @return TeamSearchUseCase object.
     */
    public PlayerStatusUseCase getPlayerStatusUseCase() {
        return new PlayerStatusUseCase(dataBase);
    }

    /**
     * Get the LeagueStandingUseCase object.
     * @return LeagueStanding object.
     */
    public LeagueStandingUseCase getLeagueStandingUseCase() {
        return new LeagueStandingUseCase(dataBase); }
}
