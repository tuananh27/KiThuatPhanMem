package Buoi7;

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoredFiles {
    private String storedFile;// name
    private JsonArray memory;

    /**
     * @param storedFile
     */
    public StoredFiles(String storedFile) {
        this.storedFile = storedFile;
        this.memory = read();
    }

    public JsonArray read() {
        JsonArray jsonArray = null;

        try (FileReader reader = new FileReader(this.storedFile)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return jsonArray;
    }

    //
    public void update(String username, Integer password, String email) {
        // theem vao memory
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("un", username);
        jsonObject.addProperty("ps", password);
        jsonObject.addProperty("email", email);

        memory.add(jsonObject); // JsonElement

    }

    public void write() {

        // ghi memory vao file
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storedFile)) {
            gson.toJson(memory, writer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    // un //mrmit
    // email
    /**
     * 
     * @param key:   un/email
     * @param value: mrteo/ mirmit
     * @return: -1: not found ; #-1 username/email exists
     */
    public int search(String key, String value) {
        String result = null;// username/email
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            result = jsonObject.get(key).getAsString();
            if (value.equals(result)) {
                return i;
            }
        }
        return -1;
    }
}
