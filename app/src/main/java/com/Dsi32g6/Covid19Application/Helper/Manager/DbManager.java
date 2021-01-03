package com.Dsi32g6.Covid19Application.Helper.Manager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.Dsi32g6.Covid19Application.Entity.Patient;
import com.Dsi32g6.Covid19Application.Helper.DataBaseHelper;
import com.Dsi32g6.Covid19Application.Helper.UserHelper.AppItem;

import java.util.Date;
import java.util.List;

public class DbManager {

    private DataBaseHelper dataBaseHelper;

    private Context context;

    private SQLiteDatabase database;

    public DbManager(Context c) {
        context = c;
    }

    public Boolean authenticate(String username, String password) {
        return dataBaseHelper.authenticate(username,password);
    }

    public DbManager open() throws SQLException {
        dataBaseHelper = new DataBaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }
    public List<Patient> trouverPersonne(String cin){
        return dataBaseHelper.trouverPersonne(database,cin);
    }

    public List<AppItem> findPersonById(){
        return dataBaseHelper.findPersonById(database);
    }
    public List<AppItem> getListItems1(){
        return dataBaseHelper.getListItems1(database);
    }

    public void close() {
        dataBaseHelper.close();
    }

    public List<AppItem> getListItems2() {
        return dataBaseHelper.getListItems2(database);

    }
    public List<AppItem> getListItems3() {
        return dataBaseHelper.getListItems3(database);

    }


  /*  public String getPriceByNamePerMagasin(String name, String choice) {

        System.err.println(name);
        System.err.println(choice);
        return dataBaseHelper.getPriceByNamePerMagasin(database,name,choice);
    }       */


    public String getUserRole(String username, String password ) {

            System.err.println(username);
            System.err.println(password);
            System.err.println(dataBaseHelper.getUserRole(database,username,password));
            return dataBaseHelper.getUserRole(database,username,password);
        }

public void InsertPatient(String cin, String nom, String prenom, int periode, String test, Date dateTest)
{
    System.err.println(nom);
    System.err.println(cin);
    System.err.println("jjjjjj");
    dataBaseHelper.InsertPatient(database,cin,nom,prenom,periode,test,dateTest);
}
}
