package utilities;

import utilities.TestDataRepo;

public class DataUtil {

    public static String generateEmail(String name){
        String cleanName = name.toLowerCase().replaceAll("\\s", "");
        return cleanName +System.currentTimeMillis() + "@gmail.com";
    }

     public static String getEmail(UserType userType){
        switch(userType){
            case NEW:
                return generateEmail("user");

            case EXISTING:
                throw new UnsupportedOperationException("EXISTING email should come from ScenarioContext");

            default:
                throw new IllegalArgumentException("Invalid user type");
        }
     }
}









