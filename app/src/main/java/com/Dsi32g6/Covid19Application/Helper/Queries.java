package com.Dsi32g6.Covid19Application.Helper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Queries {

    private static List<Map<String, String>> USERS_DATA;


    public static final String EFFACE =
            "TRUNCATE TABLE PATIENTR;";
    public static final String CREATION_QUERY =
            "CREATE TABLE USER ( ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT,password TEXT , role TEXT );";
    public static final String CREATION_Patient =
            "CREATE TABLE PATIENT ( cin TEXT PRIMARY KEY , nom TEXT,prenom TEXT , periode INTEGER , test TEXT , dateTest DATE);";
    public static final String CREATION_PatientR =
            "CREATE TABLE PATIENTR ( cin TEXT PRIMARY KEY , nom TEXT,prenom TEXT , periode INTEGER , test TEXT );";
      public static final String INSERT =
                    "INSERT INTO USER ('USERNAME','password','role') values ('police','police','p');";
    public static final String INSERT1 =
            "INSERT INTO USER ('USERNAME','password','role') values ('laboratoire','laboratoire','l');";
  //  public static final String INSERTPatient =
   //         "INSERT INTO PATIENT  values ('09620316','Tabboubi','Borhene',15,'positive','2015-01-01');";
    public static final String dropTable =
            "drop table PATIENTR ;";



         //////  selection filtrer par date //////////////////

         public static String selectRetablie( ) {
       /*      java.util.Date date=new java.util.Date();
             long firstDate = date.getTime();
             long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
             long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS); */
             String query = "SELECT * FROM PATIENT where dateTest< NOW() ;";
             return query;
         }

    public static final List<String> INSERT_QUERY(){
        fillMap();
        List<String> queries = new ArrayList<>();
        for(Map<String,String> user : USERS_DATA){
            String query =  "INSERT INTO " + Tables.USER + "(" + Rubriques.USERNAME + "," + Rubriques.PASSWORD +","+ Rubriques.ROLE +") " +
                    " VALUES ("+user.get(Rubriques.USERNAME)+" , "+user.get(Rubriques.PASSWORD)+" , "+user.get(Rubriques.ROLE)+");";
            queries.add(query);
        }
        return queries;
    }


  /*  public static String getRole(String username, String password) {
        String query = "SELECT role FROM USER where USERNAME = '"+username+"' AND password = '"+password+"';";
        return query;
    }
    */
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

        FileReader fileReader;

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
            System.err.println("erreur");

        }catch (ParseException e){
            System.err.println("erreur");

        }
        catch (IOException e) {
System.err.println("erreur");
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
    static final String ROLE ="role";

}