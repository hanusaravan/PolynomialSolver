import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PolynomialSolver {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("input.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Extract k
            JSONObject keysObj = (JSONObject) jsonObject.get("keys");
            long k = (long) keysObj.get("k");

            // Collect roots in numeric order
            TreeMap<Integer, JSONObject> roots = new TreeMap<>();
            for (Object keyObj : jsonObject.keySet()) {
                String key = (String) keyObj;
                if (!key.equals("keys")) {
                    roots.put(Integer.parseInt(key), (JSONObject) jsonObject.get(key));
                }
            }

            // Pick the k-th root in sorted order
            int count = 1;
            for (Map.Entry<Integer, JSONObject> entry : roots.entrySet()) {
                if (count == k) {
                    JSONObject root = entry.getValue();
                    System.out.println("\"" + entry.getKey() + "\": {");
                    System.out.println("    \"base\": \"" + root.get("base") + "\",");
                    System.out.println("    \"value\": \"" + root.get("value") + "\"");
                    System.out.println("}");
                    break;
                }
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
