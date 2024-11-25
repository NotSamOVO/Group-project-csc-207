package api;

import entity.Game;
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

/**
 * NFLTeamDataBase class.
 */
public class NFLTeamDataBase implements NFLDataBase {
    private static final String BASE_URL = "https://api.balldontlie.io/nfl/v1";
    private static final String API_KEY = "f0fb2b79-6fcb-47cd-b4a2-e5534b085344";

    @Override
    public Team getTeam(int teamId) {
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
    public ArrayList<Team> getAllTeams() {
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
                .addHeader("Authorization", API_KEY)
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
                .addHeader("Authorization", API_KEY)
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
    public Game getGame(int gameId) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/games/" + gameId)
                .addHeader("Authorization", API_KEY)
                .method("GET", null)
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error getting game");
            }

            final JSONObject game = responseBody.getJSONObject("data");
            final JSONObject homeTeam = game.getJSONObject("home_team");
            final JSONObject visitorTeam = game.getJSONObject("visitor_team");

            final Team homeTeamObj = Team.builder()
                    .id(homeTeam.getInt("id"))
                    .conference(homeTeam.getString("conference"))
                    .division(homeTeam.getString("division"))
                    .location(homeTeam.getString("location"))
                    .name(homeTeam.getString("name"))
                    .fullName(homeTeam.getString("full_name"))
                    .abbreviation(homeTeam.getString("abbreviation"))
                    .build();

            final Team visitorTeamObj = Team.builder()
                    .id(visitorTeam.getInt("id"))
                    .conference(visitorTeam.getString("conference"))
                    .division(visitorTeam.getString("division"))
                    .location(visitorTeam.getString("location"))
                    .name(visitorTeam.getString("name"))
                    .fullName(visitorTeam.getString("full_name"))
                    .abbreviation(visitorTeam.getString("abbreviation"))
                    .build();

            String venue = game.optString("venue", "Unknown Venue");

            return Game.builder()
                    .id(game.getInt("id"))
                    .home_team(homeTeamObj)
                    .visitor_team(visitorTeamObj)
                    .date(game.getString("date"))
                    .home_team_score(game.getInt("home_team_score"))
                    .visitor_team_score(game.getInt("visitor_team_score"))
                    .venue(venue)
                    .home_team_q1(game.optInt("home_team_q1", 0))
                    .visitor_team_q1(game.optInt("visitor_team_q1", 0))
                    .home_team_q2(game.optInt("home_team_q2", 0))
                    .visitor_team_q2(game.optInt("visitor_team_q2", 0))
                    .home_team_q3(game.optInt("home_team_q3", 0))
                    .visitor_team_q3(game.optInt("visitor_team_q3", 0))
                    .home_team_q4(game.optInt("home_team_q4", 0))
                    .visitor_team_q4(game.optInt("visitor_team_q4", 0))
                    .build();
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public ArrayList<Game> getAllGames() {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/games?seasons[]=2024")
                .addHeader("Authorization", API_KEY)
                .method("GET", null)
                .build();
        try {
            final Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new RuntimeException("Error getting games");
            }

            final String responseBody = response.body().string();
            final JSONObject jsonResponse = new JSONObject(responseBody);
            final JSONArray gamesArray = jsonResponse.getJSONArray("data");
            final ArrayList<Game> result = new ArrayList<>();
            for (int i = 0; i < gamesArray.length(); i++) {
                final JSONObject game = gamesArray.getJSONObject(i);
                final JSONObject homeTeam = game.getJSONObject("home_team");
                final JSONObject visitorTeam = game.getJSONObject("visitor_team");
                final Team homeTeamObj = Team.builder()
                        .id(homeTeam.getInt("id"))
                        .conference(homeTeam.getString("conference"))
                        .division(homeTeam.getString("division"))
                        .location(homeTeam.getString("location"))
                        .name(homeTeam.getString("name"))
                        .fullName(homeTeam.getString("full_name"))
                        .abbreviation(homeTeam.getString("abbreviation"))
                        .build();

                final Team visitorTeamObj = Team.builder()
                        .id(visitorTeam.getInt("id"))
                        .conference(visitorTeam.getString("conference"))
                        .division(visitorTeam.getString("division"))
                        .location(visitorTeam.getString("location"))
                        .name(visitorTeam.getString("name"))
                        .fullName(visitorTeam.getString("full_name"))
                        .abbreviation(visitorTeam.getString("abbreviation"))
                        .build();

                String venue = game.optString("venue", "Unknown Venue");

                result.add(Game.builder()
                        .id(game.getInt("id"))
                                .home_team(homeTeamObj)
                                .visitor_team(visitorTeamObj)
                                .date(game.getString("date"))
                                .home_team_score(game.getInt("home_team_score"))
                                .visitor_team_score(game.getInt("visitor_team_score"))
                                .venue(venue)
                        .home_team_q1(game.optInt("home_team_q1", 0))
                        .visitor_team_q1(game.optInt("visitor_team_q1", 0))
                        .home_team_q2(game.optInt("home_team_q2", 0))
                        .visitor_team_q2(game.optInt("visitor_team_q2", 0))
                        .home_team_q3(game.optInt("home_team_q3", 0))
                        .visitor_team_q3(game.optInt("visitor_team_q3", 0))
                        .home_team_q4(game.optInt("home_team_q4", 0))
                        .visitor_team_q4(game.optInt("visitor_team_q4", 0))
                        .build());
            }
            return result;

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
    public ArrayList<Season> getSeasonInfo(int year) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/standings" + "?season=" + year)
                .method("GET", null)
                .addHeader("Authorization", API_KEY)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            final JSONArray seasonArray = responseBody.getJSONArray("data");
            final ArrayList<Season> seasons = new ArrayList<>();

            if (!response.isSuccessful()) {
                throw new IOException("Error getting season info");
            }
            for (int i = 0; i < seasonArray.length(); i++) {
                final JSONObject season = seasonArray.getJSONObject(i);
                final JSONObject team = season.getJSONObject("team");
                seasons.add(Season.builder()
                        .fullName(team.getString("full_name"))
                        .wins(season.getInt("wins"))
                        .losses(season.getInt("losses"))
                        .ties(season.getInt("ties"))
                        .winningPercentage(season.getInt("wins"), season.getInt("losses"),
                                season.getInt("ties"))
                        .homeRecord(season.getString("home_record"))
                        .awayRecord(season.getString("road_record"))
                        .divisionRecord(season.getString("division_record"))
                        .conferenceRecord(season.getString("conference_record"))
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
}
