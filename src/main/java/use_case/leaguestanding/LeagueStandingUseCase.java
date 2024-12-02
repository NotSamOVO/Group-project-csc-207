package use_case.leaguestanding;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import api.NFLTeamDataBase;
import entity.Season;

/**
 * The class for the league standing use case.
 */

public final class LeagueStandingUseCase implements LeagueStandingInputBoundary {
    private NFLTeamDataBase teamstandingDataBase;
    private int year = Year.now().getValue();

    public LeagueStandingUseCase(NFLTeamDataBase teamstandingDataBase) {
        this.teamstandingDataBase = teamstandingDataBase;
    }

    /**
     * Get the league standing of current year with sorted according to winning percentage.
     * @return The teams performances in current year.
     */

    public String[][] getLeagueStanding() {
        final ArrayList<Season> standing = teamstandingDataBase.getSeasonInfo(year);
        final String[][] data = new String[standing.size()][14];

        for (int i = 0; i < standing.size(); i++) {
            final Season obj = standing.get(i);

            data[i][1] = obj.getFullName();
            data[i][2] = String.valueOf(obj.getWins());
            data[i][3] = String.valueOf(obj.getLosses());
            data[i][4] = String.valueOf(obj.getTies());
            data[i][5] = String.format("%.3f", obj.getWinningPercentage());
            data[i][6] = obj.getHomeRecord();
            data[i][7] = obj.getAwayRecord();
            data[i][8] = obj.getDivisionRecord();
            data[i][9] = obj.getConferenceRecord();
            data[i][10] = String.valueOf(obj.getPointsFor());
            data[i][11] = String.valueOf(obj.getPointsAgainst());
            data[i][12] = String.valueOf(obj.getPointsDiff());
        }

        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(String[] row1, String[] row2) {
                final double value1 = Double.parseDouble(row1[5]);
                final double value2 = Double.parseDouble(row2[5]);
                return Double.compare(value2, value1);
            }
        });

        for (int i = 0; i < data.length; i++) {
            data[i][0] = String.valueOf(i + 1);
        }

        return data;
    }

    /**
     *  Get the league standing of the team current year.
     * @param teamname Input Team Name
     * @return The team performances in current year.
     */
    public String[] getTeamStanding(String teamname) {
        final String[][] leagueStanding = getLeagueStanding();
        for (int i = 0; i < leagueStanding.length; i++) {
            final String[] standing = leagueStanding[i];
            if (standing[1].toLowerCase().contains(teamname.toLowerCase())) {
                return standing;
            }
        }
        return null;
    }
}

