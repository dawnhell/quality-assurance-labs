package services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

public class FileReaderService {
    private String FILE_PATH = System.getProperty("user.dir") + "/src/data/data.json";

    public JSONObject readDataFromFile() {
        JSONObject jsonObject = new JSONObject();

        try {
            JSONParser parser = new JSONParser();
            File       file   = new File(this.FILE_PATH);
            Object     object = parser.parse(new FileReader(file));

            jsonObject = (JSONObject) object;

            this.parseJSON(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    private void parseJSON(JSONObject jsonObject) {
        Set<Object> set = jsonObject.keySet();
        Iterator<Object> iterator = set.iterator();

        System.out.println(((JSONObject)jsonObject.get("university")).keySet().iterator().next());

        int universityId;
        System.out.println(set);

        while (iterator.hasNext()) {
            Object obj = iterator.next();

            System.out.println(obj);

            if (obj.equals("university")) {
                System.out.println();
            }


            /*if (jsonObject.get(obj) instanceof JSONArray) {
                System.out.println(obj.toString());
//                getArray(jsonObject.get(obj));
            } else {
                if (jsonObject.get(obj) instanceof JSONObject) {
                    parseJSON((JSONObject) jsonObject.get(obj));
                } else {
                    System.out.println(obj.toString() + "\t"
                            + jsonObject.get(obj));
                }
            }*/
        }

    }
}
