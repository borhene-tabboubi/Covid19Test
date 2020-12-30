package com.Dsi32g6.Covid19Application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.Dsi32g6.Covid19Application.Helper.Manager.DbManager;
import com.Dsi32g6.Covid19Application.Helper.UserHelper.AppItem;
import com.Dsi32g6.Covid19Application.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListePatient extends AppCompatActivity {
    Bundle extra;
    ListView lv_items;

    List<AppItem> items = new ArrayList<>();
    ItemAdapter adapter;

    public ListePatient() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);


        lv_items = findViewById(R.id.lv_items);
        extra = this.getIntent().getExtras();
        String cat ="2";
        int x = Integer.parseInt(cat);
        Context context = this;

        DbManager dbManager = new DbManager(this);
        dbManager.open();


        switch (x) {
            case 1: {
                items = dbManager.getListItems1();
                adapter = new ItemAdapter(getApplicationContext(), items);
                lv_items.setAdapter(adapter);
                break;
            }
            case 2: {
                items = dbManager.getListItems2();
                adapter = new ItemAdapter(getApplicationContext(), items);
                lv_items.setAdapter(adapter);
                break;
            }
            case 3: {
                items = dbManager.getListItems3();
                adapter = new ItemAdapter(getApplicationContext(), items);
                lv_items.setAdapter(adapter);
                break;
            }

        }
    }
    public void ajout(View view) {
        Intent intent = new Intent(this, LabAjout.class);
        startActivity(intent);
    }

    public void to1(View view) {
        Intent intent = new Intent(this, Items.class);
        intent.putExtra("CAT",1);
        startActivity(intent);
    }
    public void to2(View view) {
        Intent intent = new Intent(this, Items.class);
        intent.putExtra("CAT",2);
        startActivity(intent);
    }
    public void to3(View view) {
        Intent intent = new Intent(this, Items.class);
        intent.putExtra("CAT",3);
        startActivity(intent);
    }
}
