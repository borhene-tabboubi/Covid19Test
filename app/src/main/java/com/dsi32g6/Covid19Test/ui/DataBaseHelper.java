package com.dsi32g6.Covid19Test.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dsi32g6.Covid19Test.ui.UserHelper.AppItem;
import com.dsi32g6.Covid19Test.ui.UserHelper.UserHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "DAMINE.DB";

    private SQLiteDatabase mDatabase;

    private Context context;

    public DataBaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        //mDatabase =  SQLiteDatabase.openOrCreateDatabase(DBNAME,null);// this.getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("i am here");
        db.execSQL(Queries.CREATION_QUERY);
        db.execSQL(Queries.Items_CREATION_QUERY);
        db.execSQL(Queries.INSERT);
//('ITEM_NAME','ITEM_PRICE','CATEGORY','PRICE_M' , 'PRICE_C' , 'PRICE_G')
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Chips au fromage chips-up Céréalis','alimentation','2260','2400','2260','2260','alimentation1');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Biscuits choco-tom','alimentation','1190','1210','1190','1190','alimentation2');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Jus Délice de fruits','alimentation','2995','3000','2995','2975','alimentation3');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Huile de Maïs safi 1L','alimentation','4030','4430','4030','4030','alimentation4');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Mayonnaise Jadida','alimentation','2260','2700','2260','2700','alimentation5');");

        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Harissa Neblia','alimentation','2090','2660','2590','2090','alimentation6');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Boisson gazeuse 1,5L','alimentation','2330','2350','2330','2330','alimentation7');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Biscuit Binto','alimentation','1050','1150','1150','1050','alimentation8');");


        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Eau de Javel JUDY 3L','menage','2780','2860','2780','2780','menage1');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('OMO Matic Color 2.5Kg','menage','14250','17690','15990','14250','menage2');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Essuie-tout papier 4 plis','menage','6710','6990','6720','6710','menage3');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Adoucissant Comfort','menage','14060','16480','14060','14350','menage4');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Liquide Vaisselle Judy 650ml','menage','2960','3120','2960','2960','menage5');");

        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('12 Papier hygiénique Lilas','menage','2960','3120','2960','2960','menage6');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Déodorant Nivea femme','menage','7820','22760','10680','7820','menage7');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Nadhif 1,25Kg','menage','6700','7020','6700','6700','menage8');");


        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Shampoing Clear 360ML','produits_cosmetique','8490','12110','8490','9550','produits_cosmetique1');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Savonnette FA 125g','produits_cosmetique','1370','1410','1370','1370','produits_cosmetique2');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Gel douche Adidas','produits_cosmetique','6950','7690','6990','6950','produits_cosmetique3');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Déodorant AXE homme 150ML','produits_cosmetique','6690','8590','8590','8590','produits_cosmetique4');");

        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Après shampoing Garnier','produits_cosmetique','10390','10390','10390','10390','produits_cosmetique5');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','CATEGORY','ITEM_PRICE','PRICE_M' , 'PRICE_C' , 'PRICE_G','PHOTO')values ('Gel cheveux L’oréal','produits_cosmetique','16360','17340','16360','16390','produits_cosmetique6');");

       /* db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE','CATEGORY') values ('bread','100','food');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE','CATEGORY') values ('milk','300','food');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE','CATEGORY') values ('cheese','150','food');");

        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE','CATEGORY') values ('pull','2000','clothes');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE','CATEGORY') values ('shirt','2500','clothes');");
        db.execSQL("INSERT INTO ITEMS ('ITEM_NAME','ITEM_PRICE','CATEGORY') values ('T-shirt','1500','clothes');");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

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

    public List<AppItem> getListItems1(SQLiteDatabase db) {
        List<AppItem> items = new ArrayList<>();

        //openDatabase();
        Cursor cursor = db.rawQuery("select * from ITEMS where CATEGORY = 'alimentation';", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            AppItem item = new AppItem();
            item.setMin_price(cursor.getString(3));
            item.setName(cursor.getString(1));
            item.setPhoto(cursor.getString(7));
            items.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        System.err.println("FROM HELPER "+items);
        return items;
    }

    public List<AppItem> getListItems2(SQLiteDatabase database) {

        List<AppItem> items = new ArrayList<>();

        //openDatabase();
        Cursor cursor = database.rawQuery("select * from ITEMS where CATEGORY = 'menage';", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            AppItem item = new AppItem();
            item.setMin_price(cursor.getString(3));
            item.setName(cursor.getString(1));
            item.setPhoto(cursor.getString(7));
            items.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return items;
    }



    public List<AppItem> getListItems3(SQLiteDatabase database) {

        List<AppItem> items = new ArrayList<>();

        //openDatabase();
        Cursor cursor = database.rawQuery("select * from ITEMS where CATEGORY = 'produits_cosmetique';", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            AppItem item = new AppItem();
            item.setMin_price(cursor.getString(3));
            item.setName(cursor.getString(1));
            item.setPhoto(cursor.getString(7));
            items.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return items;
    }

    public String getPriceByNamePerMagasin(SQLiteDatabase database, String name, String choice) {

        Cursor cursor = database.rawQuery("select "+choice+" from ITEMS where ITEM_NAME = '"+name+"';", null);
        cursor.moveToFirst();
        String price = "-1";
        while (!cursor.isAfterLast()) {
            price = cursor.getString(0);
            cursor.moveToNext();
        }
        return price;
    }

}
