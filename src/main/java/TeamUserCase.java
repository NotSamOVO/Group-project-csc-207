import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeamUserCase {
    private static final String team = "full_name";
    public JSONObject getTeam(String teamName){
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url("https://balldontlie.io/api/v1/teams")
                .method("GET", null)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());

            if (responseBody.getString(team) == teamName) {
                return responseBody;
            } else {
                throw new RuntimeException("TeamName not found");
            }
        } catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }


    public JSONArray getAllTeams (){

    };


    public JSONObject getPlayer(String playerName){

    };

    public JSONArray getAllPlayers(){

    };

    public JSONObject getGame ( int gameId){

    };

    public JSONArray getGamesByDate (String date){

    };

    public JSONObject getSeasonInfo (int year){

    };
}