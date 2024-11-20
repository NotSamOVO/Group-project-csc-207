package use_case.leaguestanding;

import java.time.Year;

import org.json.JSONArray;

import api.NFLTeamDataBase;
/**
 * The class for the league standing use case.
 */

public final class LeagueStandingUseCase {
    private NFLTeamDataBase teamstandingDataBase = new NFLTeamDataBase();
    private int year = Year.now().getValue();

    public LeagueStandingUseCase(NFLTeamDataBase teamstandingDataBase) {
        this.teamstandingDataBase = teamstandingDataBase;
    }
    /**
     * Get the league standing of current year.
     * @return The team performances in current year.
     */

    public JSONArray getLeagueStanding() {
        return teamstandingDataBase.getSeasonInfo(year);
    }
}
