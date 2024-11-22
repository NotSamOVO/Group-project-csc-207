package use_case.leaguestanding;

import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONObject;

import api.NFLTeamDataBase;

/**
 * The class for the league standing use case.
 */

public final class LeagueStandingUseCase {
    private NFLTeamDataBase teamstandingDataBase;
    private int year = Year.now().getValue();

    public LeagueStandingUseCase(NFLTeamDataBase teamstandingDataBase) {
        this.teamstandingDataBase = teamstandingDataBase;
    }
    /**
     * Get the league standing of current year with sorted according to winning percentage.
     * @return The team performances in current year.
     */

    public String[][] getLeagueStanding() {
        final JSONArray standing = teamstandingDataBase.getSeasonInfo(year);
        final String[][] data = new String[standing.length()][14];

        for (int i = 0; i < standing.length(); i++) {
            final JSONObject obj = standing.getJSONObject(i);
            final JSONObject team = obj.getJSONObject("team");
            final int wins = obj.getInt("wins");
            final int losses = obj.getInt("losses");
            final int ties = obj.getInt("ties");
            final double totalGames = wins + losses + ties;
            final double winPercentage = (totalGames > 0) ? (double) wins / totalGames : 0.0;

            data[i][1] = team.getString("full_name");
            data[i][2] = String.valueOf(obj.getInt("wins"));
            data[i][3] = String.valueOf(obj.getInt("losses"));
            data[i][4] = String.valueOf(obj.getInt("ties"));
            data[i][5] = String.format("%.3f", winPercentage);
            data[i][6] = obj.getString("home_record");
            data[i][7] = obj.getString("road_record");
            data[i][8] = obj.getString("division_record");
            data[i][9] = obj.getString("conference_record");
            data[i][10] = String.valueOf(obj.getInt("points_for"));
            data[i][11] = String.valueOf(obj.getInt("points_against"));
            data[i][12] = String.valueOf(obj.getInt("point_differential"));
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
}
