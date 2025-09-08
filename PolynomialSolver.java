import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PolynomialSolver {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("input.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONObject keysObj = (JSONObject) jsonObject.get("keys");
            int n = ((Long) keysObj.get("n")).intValue(); // number of roots

            // Get all root keys in sorted order
            Set<String> rootKeys = new TreeSet<>();
            for (Object keyObj : jsonObject.keySet()) {
                String key = (String) keyObj;
                if (!key.equals("keys")) {
                    rootKeys.add(key);
                }
            }

            BigInteger product = BigInteger.ONE;

            for (String key : rootKeys) {
                JSONObject root = (JSONObject) jsonObject.get(key);
                String baseStr = (String) root.get("base");
                String valueStr = (String) root.get("value");

                int base = Integer.parseInt(baseStr);
                BigInteger decimalValue = new BigInteger(valueStr, base);

                product = product.multiply(decimalValue);
            }

            // Apply (-1)^n
            if (n % 2 != 0) {
                product = product.negate();
            }

            // Print constant term in JSON format
            System.out.println("{");
            System.out.println("  \"c\": " + product);
            System.out.println("}");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
