package LeagueStandingTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import api.NFLTeamDataBase;
import entity.Season;
import use_case.leaguestanding.LeagueStandingUseCase;

class LeagueStandingUseCaseTest {

    private LeagueStandingUseCase leagueStandingUseCase;

    @BeforeEach
    void setUp() {
        // Mock NFLTeamDataBase with test data
        NFLTeamDataBase mockDatabase = new NFLTeamDataBase() {
            @Override
            public ArrayList<Season> getSeasonInfo(int year) {
                ArrayList<Season> mockData = new ArrayList<>();
                mockData.add(new Season("Golden Eagles", 400, 300, 100, 10, 3, 1, "4-0", "6-2", "6-1", "5-1", 0.769));
                mockData.add(new Season("Silver Hawks", 350, 320, 30, 8, 5, 1, "3-1", "5-4", "5-3", "4-2", 0.615));
                return mockData;
            }
        };

        leagueStandingUseCase = new LeagueStandingUseCase(mockDatabase);
    }

    @Test
    void testGetLeagueStanding() {
        String[][] leagueStanding = leagueStandingUseCase.getLeagueStanding();

        assertNotNull(leagueStanding, "League standing should not be null");
        assertEquals(2, leagueStanding.length, "There should be 2 teams in the league standing");
        assertEquals("Golden Eagles", leagueStanding[0][1], "Top-ranked team should be 'Golden Eagles'");
        assertEquals("0.769", leagueStanding[0][5], "Winning percentage for 'Golden Eagles' should be 0.769");
    }

    @Test
    void testGetTeamStanding() {
        String[] teamStanding = leagueStandingUseCase.getTeamStanding("Golden Eagles");

        assertNotNull(teamStanding, "Team standing for 'Golden Eagles' should not be null");
        assertEquals("Golden Eagles", teamStanding[1], "Team name should match 'Golden Eagles'");
        assertEquals("10", teamStanding[2], "Wins for 'Golden Eagles' should be 10");

        String[] nonExistentTeam = leagueStandingUseCase.getTeamStanding("Non Existent");
        assertNull(nonExistentTeam, "Non-existent team should return null");
    }

    @Test
    void testCaseInsensitiveSearch() {
        String[] teamStanding = leagueStandingUseCase.getTeamStanding("golden eagles");
        assertNotNull(teamStanding, "Search should be case-insensitive");
        assertEquals("Golden Eagles", teamStanding[1]);
    }
}
