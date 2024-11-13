import okhttp3.*;

import java.io.IOException;

public class TeamUserCase {
    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    MediaType mediaType = MediaType.parse("text/plain");
    RequestBody body = RequestBody.create(mediaType, "");
    Request request = new Request.Builder()
            .url("https://balldontlie.io/api/v1/teams")
            .method("GET", body)
            .build();
    Response response = client.newCall(request).execute();

    public TeamUserCase() throws IOException {
    }
}
