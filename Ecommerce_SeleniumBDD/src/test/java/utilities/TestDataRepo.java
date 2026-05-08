package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class TestDataRepo {
    private static JsonNode testData;
    static{
        try{
            ObjectMapper mapper = new ObjectMapper();
            testData = mapper.readTree(new File("src/test/resources/TestData.json"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }

    public static JsonNode getSignupData() {
        return testData.get("NewUser");
    }

    public static JsonNode getExistingUserData() {
        return testData.get("ExistingUser");
    }

}
