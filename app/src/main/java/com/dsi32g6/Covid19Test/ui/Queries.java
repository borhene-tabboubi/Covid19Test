package com.example.testapplication.Helper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Queries {

    private static List<Map<String, String>> USERS_DATA;



    public static final String CREATION_QUERY =
            "CREATE TABLE USER ( ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT,password TEXT , role TEXT );";
    public static final String Items_CREATION_QUERY =
            "CREATE TABLE ITEMS ( ITEM_ID INTEGER PRIMARY KEY AUTOINCREMENT, ITEM_NAME TEXT,CATEGORY TEXT, ITEM_PRICE TEXT, PRICE_M TEXT, PRICE_C TEXT, PRICE_G TEXT,PHOTO TEXT );";

    public static final String INSERT =
            "INSERT INTO USER ('USERNAME','password','role') values ('police','police','p');";

    public static final List<String > insert() {
        List<String > insert_queries = new ArrayList<String>(){{
            add("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE','CATEGORY','PRICE_M' , 'PRICE_C' , 'PRICE_G') values ('Chips au fromage chips-up Céréalis','Alimentation','2260','2400','2260','2260');");
            add("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE') values ('bread','food',100');");
            add("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE') values ('cheese','food',1000');");
            add("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE') values ('water','food',200');");
        }};

        return insert_queries;
    }



    public static final List<String> INSERT_QUERY(){
        fillMap();
        List<String> queries = new ArrayList<>();
        for(Map<String,String> user : USERS_DATA){
            String query =  "INSERT INTO " + Tables.USER + "(" + Rubriques.USERNAME + "," + Rubriques.PASSWORD + ") " +
                    " VALUES ("+user.get(Rubriques.USERNAME)+" , "+user.get(Rubriques.PASSWORD)+");";
            queries.add(query);
        }
        return queries;
    }
    public static String getRole(String username, String password) {
        String query = "SELECT role FROM USER where USERNAME = '"+username+"' AND password = '"+password+"';";
                /*"SELECT " + Rubriques.USERNAME + " , " + Rubriques.PASSWORD + " FROM " + Tables.USER +
                        " WHERE " + Rubriques.USERNAME + " = '" + username
                        + "' AND " + Rubriques.PASSWORD + " = '" + password
                        + "' ;"; */
        return query;
    }
    public static String AUTHENTICATION_QUERY(String username, String password) {
        String query = "SELECT * FROM USER where USERNAME = '"+username+"' AND password = '"+password+"';";
                /*"SELECT " + Rubriques.USERNAME + " , " + Rubriques.PASSWORD + " FROM " + Tables.USER +
                        " WHERE " + Rubriques.USERNAME + " = '" + username
                        + "' AND " + Rubriques.PASSWORD + " = '" + password
                        + "' ;"; */
        return query;
    }

    public static String LOAD_USER_QUERY(String username, String password) {
        String query = "SELECT * FROM USER where USERNAME = '"+username+"' AND password = '"+password+"';";
                /*"SELECT " + Rubriques.ID_USER + "," + Rubriques.USERNAME + " FROM " + Tables.USER +
                        " WHERE " + Rubriques.USERNAME + " = '" + username
                        + "' AND " + Rubriques.PASSWORD + " = '" + password
                        + "' ;";*/
        return query;
    }

    private static void fillMap() {

        FileReader fileReader = null;

        JSONParser jsonParser = new JSONParser();
        try {
            fileReader = new FileReader("Users.json");
            Object obj = jsonParser.parse(fileReader);
            JSONArray userslist = (JSONArray) obj;

            for (Object user : userslist){
                JSONObject jsonUser = (org.json.simple.JSONObject) user;
                Map<String,String> mapperUser = new LinkedHashMap<>();
                mapperUser.put(Rubriques.USERNAME,jsonUser.get("username").toString());
                mapperUser.put(Rubriques.PASSWORD,jsonUser.get("password").toString());
                USERS_DATA.add(mapperUser);
            }

        } catch (FileNotFoundException e) {

        }catch (ParseException e){

        }
        catch (IOException e) {

        }
    }


}

class Tables {
    static final String USER = "user";
}

class Rubriques {
    static final String ID_USER = "iduser";

    static final String USERNAME = "username";
    static final String PASSWORD = "password";

}