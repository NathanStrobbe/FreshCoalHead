package fr.pinath.skull;

import org.bukkit.Bukkit;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSkull {
    private Category category;
    private static final String URL = "https://freshcoal.com/mainapi.php?query=";
    private String body;

    public DataSkull(Category category) {
        this.category = category;
        this.body = "";
    }

    private void connect() {
        StringBuilder query = new StringBuilder().append(URL).append(category.getQuery());
        URL url;
        try {
            url = new URL(query.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            String json = new Scanner(inStream, "UTF-8").useDelimiter("\\Z").next();
            body = parseBody(json);
            connection.disconnect();
        } catch (Exception e) {
            Bukkit.getLogger().severe(e.getMessage());
        }
    }

    public List<Skull> collectSkull() {
        connect();
        List<JSONObject> heads = new ArrayList<>();
        JSONArray array = new JSONArray(body);
        for (Object head : array) {
            JSONObject object = new JSONObject(head.toString());
            heads.add(object);
        }
        return intoSkull(heads);
    }

    private List<Skull> intoSkull(List<JSONObject> heads) {
        List<Skull> skulls = new ArrayList<>();
        for (JSONObject head : heads) {
            skulls.add(new Skull(head.getString("name"), head.getString("value")));
        }
        return skulls;
    }

    private String parseBody(String json) {
        return json.split("<body>")[1].split("</body>")[0];
    }
}
