package app;

import api.NFLTeamDataBase;
import use_case.PlayerStatusUseCase;
import use_case.leaguestanding.LeagueStandingUseCase;
import use_case.teamsearch.TeamSearchUseCase;

public class Config {
    private static final NFLTeamDataBase dataBase = new NFLTeamDataBase();

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

    /**
     * Get the LeagueStandingUseCase object.
     * @return LeagueStanding object.
     */
    public LeagueStandingUseCase getLeagueStandingUseCase() {
        return new LeagueStandingUseCase(dataBase); }

    /**
     * Get the single instance of NFLTeamDataBase
     * @return an instance of NFLTeamDataBase.
     */
    public static NFLTeamDataBase getNflTeamDataBase() {
        return dataBase;
    }
}
