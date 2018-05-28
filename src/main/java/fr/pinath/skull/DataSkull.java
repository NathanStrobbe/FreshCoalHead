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

/**
 * Collects the data of skulls from the website API of Fresh Coal
 *
 * @author Pinath
 * @see <a href="http://freshcoal.com/mainapi.php">Fresh Coal</a>
 */
public class DataSkull {
    private Category category;
    private static final String URL = "https://freshcoal.com/mainapi.php?query=";
    private String body;

    public DataSkull(Category category) {
        this.category = category;
        this.body = "";
    }

    /**
     * Connect to the website API and collect the query associate to the {@link DataSkull#category}
     */
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

    /**
     * Collect all skulls from the website API
     *
     * @return a {@link List<Skull>}
     */
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

    /**
     * Transform raw data of skull into {@link Skull}
     *
     * @param heads a {@link List<JSONObject>} containing raw data of skull
     * @return a {@link List<Skull>}
     */
    private List<Skull> intoSkull(List<JSONObject> heads) {
        List<Skull> skulls = new ArrayList<>();
        for (JSONObject head : heads) {
            skulls.add(new Skull(head.getString("name"), head.getString("value")));
        }
        return skulls;
    }

    /**
     * Parse the HTML body in order to get the necessary data
     *
     * @param json the body
     * @return data from the HTML body
     */
    private String parseBody(String json) {
        return json.split("<body>")[1].split("</body>")[0];
    }
}
