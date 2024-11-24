package api;

import entity.Season;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import entity.Player;
import entity.Team;

public class NFLTeamDataBase implements NFLDataBase {
    private static final String BASE_URL = "https://api.balldontlie.io/nfl/v1";
    private static final String API_KEY = "612e0802-b513-43d0-8aba-ea3e3048fdcd";

    @Override
    public Team getTeam(int teamId){
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/teams/" + teamId)
                .method("GET", null)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());

            if (!response.isSuccessful()) {
                throw new IOException("Error getting team");
            }
            return Team.builder()
                    .id(responseBody.getInt("id"))
                    .conference(responseBody.getString("conference"))
                    .division(responseBody.getString("division"))
                    .location(responseBody.getString("location"))
                    .name(responseBody.getString("name"))
                    .fullName(responseBody.getString("full_name"))
                    .abbreviation(responseBody.getString("abbreviation"))
                    .build();
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public ArrayList<Team> getAllTeams(){
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/teams")
                .method("GET", null)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Error getting team");
            }
            final String responseBody = response.body().string();
            final JSONObject jsonResponse = new JSONObject(responseBody);
            final JSONArray teamsArray = jsonResponse.getJSONArray("data");
            final ArrayList<Team> teams = new ArrayList<>();

            for (int i = 0; i < teamsArray.length(); i++) {
                JSONObject team = teamsArray.getJSONObject(i);
                teams.add(Team.builder()
                        .id(team.getInt("id"))
                        .conference(team.getString("conference"))
                        .division(team.getString("division"))
                        .location(team.getString("location"))
                        .name(team.getString("name"))
                        .fullName(team.getString("full_name"))
                        .abbreviation(team.getString("abbreviation"))
                        .build());
            }
            return teams;
        } catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public Player getPlayer(int playerId) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/players/" + playerId)
                .method("GET", null)
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            if (!response.isSuccessful()) {
                throw new RuntimeException("Player not found");
            }
            JSONObject team = responseBody.getJSONObject("team");
            Team teamObj = Team.builder()
                    .id(team.getInt("id"))
                    .conference(team.getString("conference"))
                    .division(team.getString("division"))
                    .location(team.getString("location"))
                    .name(team.getString("name"))
                    .fullName(team.getString("full_name"))
                    .abbreviation(team.getString("abbreviation"))
                    .build();

            return Player.builder()
                    .id(responseBody.getInt("id"))
                    .firstName(responseBody.getString("first_name"))
                    .lastName(responseBody.getString("last_name"))
                    .position(responseBody.getString("position"))
                    .positionAbbreviation(responseBody.getString("position_abbreviation"))
                    .height(responseBody.getString("height"))
                    .weight(responseBody.getString("weight"))
                    .jerseyNumber(responseBody.getString("jersey_number"))
                    .college(responseBody.getString("college"))
                    .experience(responseBody.getString("experience"))
                    .age(responseBody.getInt("age"))
                    .team(teamObj)
                    .build();
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public ArrayList<Player> getAllPlayers() {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/players")
                .method("GET", null)
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            final JSONArray playerArray = responseBody.getJSONArray("data");
            final ArrayList<Player> players = new ArrayList<>();

            if (!response.isSuccessful()) {
                throw new RuntimeException("Error getting players");
            }
            for (int i = 0; i < playerArray.length(); i++) {
                JSONObject player = playerArray.getJSONObject(i);
                JSONObject team = player.getJSONObject("team");
                Team teamObj = Team.builder()
                        .id(team.getInt("id"))
                        .conference(team.getString("conference"))
                        .division(team.getString("division"))
                        .location(team.getString("location"))
                        .name(team.getString("name"))
                        .fullName(team.getString("full_name"))
                        .abbreviation(team.getString("abbreviation"))
                        .build();

                players.add(Player.builder()
                        .id(player.getInt("id"))
                        .firstName(player.getString("first_name"))
                        .lastName(player.getString("last_name"))
                        .position(player.getString("position"))
                        .positionAbbreviation(player.getString("position_abbreviation"))
                        .height(player.getString("height"))
                        .weight(player.getString("weight"))
                        .jerseyNumber(player.getString("jersey_number"))
                        .college(player.getString("college"))
                        .experience(player.getString("experience"))
                        .age(player.getInt("age"))
                        .team(teamObj)
                        .build());
            }
            return players;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public JSONObject getGame(int gameId) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/games/" + gameId)
                .method("GET", null)
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error getting game");
            }
            return responseBody;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public JSONArray getGamesByDate(String date) throws JSONException {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/games?dates[]=/" + date)
                .method("GET", null)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error getting games");
            }
            final JSONArray games = responseBody.getJSONArray("data");
            return games;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public JSONArray getSeasonInfo(int year) throws JSONException {
        return null;
    }

//    @Override
//    public JSONArray getSeasonInfo(int year) {
//        final OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        final Request request = new Request.Builder()
//                .url(BASE_URL + "/standings" + "?season=" + year)
//                .method("GET", null)
//                .build();
//
//        try {
//            final Response response = client.newCall(request).execute();
//            final JSONObject responseBody = new JSONObject(response.body().string());
//            if (!response.isSuccessful()) {
//                throw new IOException("Error getting season info");
//            }
//            return responseBody.names();
//        }
//        catch (IOException | JSONException event) {
//            throw new RuntimeException(event);
//        }
//    }

    @Override
    public ArrayList<Season> getSeasonInfoArrayList(int year) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/standings" + "?season=" + year)
                .addHeader("Authorization", API_KEY)
                .method("GET", null)
                .build();

        try {
            final Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new RuntimeException("Error getting season info");
            }

            final String responseBody = response.body().string();
            final JSONObject jsonResponse = new JSONObject(responseBody);
            final JSONArray seasonArray = jsonResponse.getJSONArray("data");
            final ArrayList<Season> seasons = new ArrayList<>();
            for (int i = 0; i < seasonArray.length(); i++) {
                final JSONObject season = seasonArray.getJSONObject(i);
                final JSONObject homeTeam = season.getJSONObject("team");
                final Team homeTeamObj = Team.builder()
                        .id(homeTeam.getInt("id"))
                        .conference(homeTeam.getString("conference"))
                        .division(homeTeam.getString("division"))
                        .location(homeTeam.getString("location"))
                        .name(homeTeam.getString("name"))
                        .fullName(homeTeam.getString("full_name"))
                        .abbreviation(homeTeam.getString("abbreviation"))
                        .build();

                seasons.add(Season.builder()
                        .teamId(homeTeam.getInt("id"))
                        .fullName(homeTeamObj.getFullName())
                        .conferenceRecord(season.getString("conference_record"))
                        .divisionRecord(season.getString("division_record"))
                        .awayRecord(season.getString("road_record"))
                        .homeRecord(season.getString("home_record"))
                        .wins(season.getInt("wins"))
                        .losses(season.getInt("losses"))
                        .ties(season.getInt("ties"))
                        .pointsFor(season.getInt("points_for"))
                        .pointsAgainst(season.getInt("points_against"))
                        .pointsDiff(season.getInt("point_differential"))
                        .build());
            }
            return seasons;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public ArrayList<Season> getTeamHistoricalSeasons(int teamId, int pastSeasonsCount) {
        ArrayList<Season> allSeasons = new ArrayList<>();
        final int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        for (int i = 0; i < pastSeasonsCount; i++) {
            final int year = currentYear - i;
            final ArrayList<Season> seasons = getSeasonInfoArrayList(year);
            for (Season season : seasons) {
                if (season.getTeamId() == teamId) {
                    allSeasons.add(season);
                }
            }
        }
        return allSeasons;
    }
}
