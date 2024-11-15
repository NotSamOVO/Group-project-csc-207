import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class TeamUserCase {
    private static final String BASE_URL = "https://balldontlie.io/api/v1";
    private static final String team = "id";
    public JSONObject getTeam(int teamId){
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/teams/" + teamId)
                .method("GET", null)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return responseBody;
        } catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }

    public JSONArray getAllTeams(){
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(BASE_URL + "/teams")
                .method("GET", null)
                .build();
        
        try {
            final Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String responseBody = response.body().string();
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray teamsArray = jsonResponse.getJSONArray("data");
            JSONArray result = new JSONArray();

            for (int i = 0; i < teamsArray.length(); i++) {
                JSONObject team = teamsArray.getJSONObject(i);
                JSONObject teamInfo = new JSONObject();
                teamInfo.put("id", team.getInt("id"));
                teamInfo.put("name", team.getString("full_name"));
                result.put(teamInfo);
            }

            return result;
        } catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }
    }

    public JSONObject getPlayer(int playerId){

    }

    public JSONArray getAllPlayers(){

    }

    public JSONObject getGame(int gameId){

    }

    public JSONArray getGamesByDate(String date){

    }

    public JSONObject getSeasonInfo (int year){

    }
}