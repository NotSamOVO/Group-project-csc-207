package api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class NFLTeamDataBase implements NFLDataBase {
    private static final String BASE_URL = "https://api.balldontlie.io/nfl/v1";
    private static final String API_KEY = "f0fb2b79-6fcb-47cd-b4a2-e5534b085344";

    @Override
    public JSONObject getTeam(int teamId) {
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
                throw new IOException("Unexpected code " + response);
            }
            return responseBody;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public JSONArray getAllTeams() {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/teams")
                .method("GET", null)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            final String responseBody = response.body().string();
            final JSONObject jsonResponse = new JSONObject(responseBody);
            final JSONArray teamsArray = jsonResponse.getJSONArray("data");
            final JSONArray result = new JSONArray();

            for (int i = 0; i < teamsArray.length(); i++) {
                JSONObject team = teamsArray.getJSONObject(i);
                JSONObject teamInfo = new JSONObject();
                teamInfo.put("id", team.getInt("id"));
                teamInfo.put("name", team.getString("full_name"));
                result.put(teamInfo);
            }
            return result;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public JSONObject getPlayer(int playerId) {
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
            return responseBody;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public JSONArray getAllPlayers() {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/players")
                .method("GET", null)
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());

            if (!response.isSuccessful()) {
                throw new RuntimeException("Error getting players");
            }
            return responseBody.getJSONArray("data");
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
                .addHeader("Authorization", API_KEY)
                .method("GET", null)
                .build();
        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error getting game");
            }
            return responseBody.getJSONObject("data");
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public JSONArray getAllGames() {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/games")
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
            return gamesArray;
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
    public JSONObject getSeasonInfo(int year) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/standings" + "?season=" + year)
                .method("GET", null)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            if (!response.isSuccessful()) {
                throw new IOException("Error getting season info");
            }
            return responseBody;
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }
}
