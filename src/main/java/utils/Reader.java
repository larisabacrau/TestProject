package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    //method to read data and return JSON object from json file
    public static JSONObject json(String name) {
        String jsonPath = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\" + name + ".json";
        System.out.println("path:" + jsonPath);
        //read the json file from the specified location
        FileReader reader = null;

        try {
            reader = new FileReader(jsonPath);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //define the parser for the json content
        JSONParser jsonParser = new JSONParser();
        //define the JSONObject
        JSONObject obj = null;

        try {
            obj = (JSONObject) jsonParser.parse(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return obj;
    }
}
