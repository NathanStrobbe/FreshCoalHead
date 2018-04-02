package fr.pinath.skull;

import org.bukkit.Bukkit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public void connect() {
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

    public List<JSONObject> collectData() {
        List<JSONObject> heads = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(body);
            for (Object head : array) {
                JSONObject object = (JSONObject) parser.parse(head.toString());
                heads.add(object);
            }
        } catch (ParseException e) {
            Bukkit.getLogger().severe(e.getMessage());
        }
        return heads;
    }

    private String parseBody(String json) {
        return json.split("<body>")[1].split("</body>")[0];
    }
}
