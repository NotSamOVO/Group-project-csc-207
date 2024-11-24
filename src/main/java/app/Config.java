package app;

import api.NFLTeamDataBase;
import api.NFLDataBase;
<<<<<<< HEAD
import use_case.matchresults.MatchResultsUseCase;
=======
import use_case.PlayerStatusUseCase;
import use_case.leaguestanding.LeagueStandingUseCase;
>>>>>>> origin/main
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
<<<<<<< HEAD
     * Get the MatchResults object.
     * @return MatchResults object.
     */
    public MatchResultsUseCase getMatchResultsUseCase() {
        return new MatchResultsUseCase(dataBase);
    }
=======
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
>>>>>>> origin/main
}
