package com.Dsi32g6.Covid19Application.Helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.Dsi32g6.Covid19Application.Entity.Patient;
import com.Dsi32g6.Covid19Application.Helper.UserHelper.AppItem;
import com.Dsi32g6.Covid19Application.Helper.UserHelper.UserHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Covid.DB";

    private SQLiteDatabase mDatabase;

    private Context context;

    public DataBaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        //mDatabase =  SQLiteDatabase.openOrCreateDatabase(DBNAME,null);// this.getWritableDatabase();
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
      //  System.out.println("i am here");
        db.execSQL(Queries.CREATION_QUERY);
     //   db.execSQL(Queries.dropTable);
        db.execSQL(Queries.CREATION_Patient);
        db.execSQL(Queries.CREATION_PatientR);
        db.execSQL(Queries.INSERT);
        db.execSQL(Queries.INSERT1);
     //  db.execSQL(Queries.EFFACE);
    //    db.execSQL(Queries.INSERTPatient);
   //     filtrerPatient(db);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//////////////////////// authentification /////////////////////////////////
    public Boolean authenticate(String username, String password) {
        openDatabase();
        Cursor cursor = mDatabase.rawQuery(Queries.AUTHENTICATION_QUERY(username, password), null);
        cursor.moveToFirst();

        if (cursor.getCount() != 0) {
            loadUser(username, password);
            return true;
        }
        cursor.close();
        return false;
    }
///////////////////// ouvrir database ///////////////////////
    public void openDatabase() {
        String dbPath = context.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    private void loadUser(String username, String password) {
        Cursor cursor = mDatabase.rawQuery(Queries.LOAD_USER_QUERY(username, password), null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            UserHelper.setUserID(cursor.getInt(0));
            UserHelper.setUsername(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        //  closeDatabase();
    }


       ////////////////// recherche personne /////////////

    public List<AppItem> findPersonById(SQLiteDatabase database) {
        List<AppItem> items = new ArrayList<>();

        //openDatabase();
        Cursor cursor = database.rawQuery("select * from PATIENT where test = 'positive';", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            AppItem item = new AppItem();
            item.setMin_price(cursor.getString(5));
            item.setCin(cursor.getString(0));
            item.setName(cursor.getString(2));
            item.setPrenom(cursor.getString(1));
            item.setPhoto(cursor.getString(0));
            item.setEtat("Positive");
            java.util.Date date1=new java.util.Date();
            if(diffDate(convertDate(cursor.getString(5)),date1)<Integer.parseInt(cursor.getString(3))) {

                items.add(item);
            }

            cursor.moveToNext();
        }
        cursor.close();
        return items;
    }








    /////////////////////////  recherche personne /////////////////////


    public List<Patient> trouverPersonne(SQLiteDatabase database ,String cin) {
        List<Patient> patient = new ArrayList<>();

        //openDatabase();
        Cursor cursor = database.rawQuery("select * from PATIENT where cin ='"+cin+"';", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Patient item = new Patient();
            item.setCin(cursor.getString(0));
            item.setNom(cursor.getString(1));
            item.setPrenom(cursor.getString(2));
            item.setPeriode(Integer.parseInt(cursor.getString(3)));
            item.setTest(cursor.getString(4));
            item.setDateTest(convertDate(cursor.getString(5)));
            item.setDateString(cursor.getString(5));
            patient.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        if (patient==null)
        {
            Patient item = new Patient();
            item.setCin("0000");
            item.setNom("0000");
            item.setPrenom("0000");
            patient.add(item);
        }

        return patient;
    }
    /*
    public static String getUserRole(String username, String password) {
        String countQuery = "SELECT role FROM USER where USERNAME = '"+username+"' AND password = '"+password+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        String count = cursor.getString(1);
        cursor.close();
        return count;
    }
*/
 ////////////////////////// listes   des infecté (en cours ) //////////////


    public List<AppItem> getListItems1(SQLiteDatabase database) {
        List<AppItem> items = new ArrayList<>();

        //openDatabase();
        Cursor cursor = database.rawQuery("select * from PATIENT where test = 'positive';", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            AppItem item = new AppItem();
            item.setMin_price(cursor.getString(5));
            item.setCin(cursor.getString(0));
            item.setName(cursor.getString(2));
            item.setPrenom(cursor.getString(1));
            item.setPhoto(cursor.getString(0));
            item.setEtat("Positive");
            java.util.Date date1=new java.util.Date();
            if(diffDate(convertDate(cursor.getString(5)),date1)<Integer.parseInt(cursor.getString(3))) {

                items.add(item);
            }

            cursor.moveToNext();
        }
        cursor.close();
        return items;
    }



    //////////////// listes des retablis /////////////////////////////

    public List<AppItem> getListItems2(SQLiteDatabase database) {

        List<AppItem> items = new ArrayList<>();

        //openDatabase();
        Cursor cursor = database.rawQuery("select * from PATIENT where test = 'positive';", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            AppItem item = new AppItem();
            item.setMin_price(cursor.getString(5));
            item.setCin(cursor.getString(0));
            item.setName(cursor.getString(2));
            item.setPrenom(cursor.getString(1));
            item.setPhoto(cursor.getString(0));
            java.util.Date date1=new java.util.Date();
            String s=cursor.getString(5);
            item.setEtat("Retabli");
            if(diffDate(convertDate(cursor.getString(5)),date1)>=Integer.parseInt(cursor.getString(3))) {

                  items.add(item);
            }
            cursor.moveToNext();
        }
        cursor.close();





        return items;
    }

    /////////////conversion date ////////////////////


    @SuppressLint("SimpleDateFormat")
    public static Date convertDate(String dd){

        Date  date1=null;
        try {
            date1=new SimpleDateFormat("yyyy-MM-dd").parse(dd);



        } catch (ParseException e) {
            System.out.println("erreur")  ;
        }
        return date1;
    }

     /////////// filtrer Patient Retabli ////////////////////

    public void filtrerPatient(SQLiteDatabase database) {
        List<Patient> patient = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from PATIENT  ;",null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Patient item = new Patient();

            item.setCin(cursor.getString(0));
            item.setNom(cursor.getString(1));
            item.setPrenom(cursor.getString(2));
            item.setPeriode(Integer.parseInt(cursor.getString(3)));
            item.setTest(cursor.getString(4));
          //  item.setDateTest(convertDate(cursor.getString(5)));
            java.util.Date date1=new java.util.Date();
        //   if(diffDate(convertDate(cursor.getString(5)),date1)>1)
         //  {
                patient.add(item);
          //  }

            cursor.moveToNext();
        }

        cursor.close();
        for (Patient n :patient)
        {
            database.execSQL("INSERT INTO PATIENTR  values ('"+n.getCin()+"','"+n.getNom()+"','"+n.getPrenom()+"',"+n.getPeriode()+",'"+n.getTest()+"')");
        }

    }


    ///////////// tester diff entre deux date //////////////

    public static long diffDate ( Date secondDate, Date firstDate )
    {
        if (secondDate==null)
        {
            System.err.println("1er date probleme");
        }
        if (firstDate==null)
        {
            System.err.println("2eme date probleme");
        }
        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.err.println("gggggggggggggggggg"+diff);
        return diff;

    }
/////////////////////////// Fin diffDate()  //////////////////


    public List<AppItem> getListItems3(SQLiteDatabase database) {

        List<AppItem> items = new ArrayList<>();

        //openDatabase();
        Cursor cursor = database.rawQuery("select * from PATIENT where test = 'negative';", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            AppItem item = new AppItem();
            item.setMin_price(cursor.getString(5));
            item.setCin(cursor.getString(0));
            item.setName(cursor.getString(2));
            item.setPrenom(cursor.getString(1));
            item.setPhoto(cursor.getString(0));
            item.setEtat("Negative");
            items.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return items;
    }

 /*   public String getPriceByNamePerMagasin(SQLiteDatabase database,String name, String choice) {

        Cursor cursor = database.rawQuery("select "+choice+" from ITEMS where ITEM_NAME = '"+name+"';", null);
        cursor.moveToFirst();
        String price = "-1";
        while (!cursor.isAfterLast()) {
            price = cursor.getString(0);
            cursor.moveToNext();
        }
        return price;
    }  */

    /////////////      recuperer le role ///////////////////


    public String getUserRole(SQLiteDatabase database,String username, String password) {
        String rol = "-1";
        Cursor cursor = database.rawQuery("select  role  from USER where USERNAME = '"+username+"' and password = '"+password+"';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            rol = cursor.getString(0);
            cursor.moveToNext();
        }
        cursor.close();
        return rol;
    }

///////////////     nsertion patient //////////////////////////



public void InsertPatient (SQLiteDatabase database,String cin , String nom , String prenom ,int periode , String test , Date dateTest)
{

    database.execSQL("INSERT INTO PATIENT  values ('"+cin+"','"+nom+"','"+prenom+"',"+periode+",'"+test+"','"+dateTest+"')");
}
/*
    public void insertDatum (String name, double a, double b, double scalefactor, double falseeasting) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_A, a);
        contentValues.put(COL_B, b);
        contentValues.put(COL_SF, scalefactor);
        contentValues.put(COL_FEASTING, falseeasting);
        db.insert(TABLE_DATUM, null, contentValues);
    }
*/


}
