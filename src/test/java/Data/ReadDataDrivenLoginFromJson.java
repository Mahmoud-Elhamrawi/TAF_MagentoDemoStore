package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class ReadDataDrivenLoginFromJson {
    String successFullLogin = "success";


    private String[] readJson(String testStatus) throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader("./src\\test\\resources\\userRegister.json");
        Object object = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(testStatus);
        String arr[] = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject users = (JSONObject) jsonArray.get(i);

            String email = (String) users.get("eamil");
            String pass = (String) users.get("pass");


            arr[i] = email + "," + pass  ;
        }
        return arr;
    }


    public String[] testDataForSucessfulRegister() throws IOException, ParseException, org.json.simple.parser.ParseException {
        return readJson(successFullLogin);
    }


}
