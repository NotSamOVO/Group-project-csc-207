import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TeamUserCase implements BasketBallDataBase {
    private static final String BASE_URL = "https://balldontlie.io/api/v1";
    private static final String team = "id";

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

            if (responseBody.getInt(team) == teamId) {
                return responseBody;
            }
            else {
                throw new RuntimeException("Team not found");
            }
        }
        catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    @Override
    public JSONArray getAllTeams() {

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
    public JSONObject getSeasonInfo(int year) throws JSONException {
        return null;
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
}
