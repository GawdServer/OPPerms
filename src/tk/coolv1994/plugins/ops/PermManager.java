package tk.coolv1994.plugins.ops;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import tk.coolv1994.gawdapi.perms.PermissionManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Vinnie on 4/17/2015.
 */
public class PermManager implements PermissionManager {
    private final HashMap<String, Integer> ops;

    public PermManager () {
        ops = new HashMap<>();
    }

    public boolean hasPermission(String username, String permission) {
        if (ops.containsKey(username)) {
            return ops.get(username).equals(4); // 4 = Full OP
        }
        return false;
    }

    public void loadPerms() {
        System.out.println("[OPs] Loading Operators...");
        ops.clear();
        JsonParser parser = new JsonParser();
        try {
            JsonArray a = (JsonArray) parser.parse(new FileReader("ops.json"));
            for (Object o : a) {
                JsonObject user = (JsonObject) o;
                ops.put(user.get("name").getAsString(), user.get("level").getAsInt());
            }
        } catch (IOException e) {
            System.out.println("[OPs] Error reading ops.json...\n" + e.getMessage());
        }
    }
}
