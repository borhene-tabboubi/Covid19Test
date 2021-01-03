package com.Dsi32g6.Covid19Application;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.Dsi32g6.Covid19Application.Helper.Manager.DbManager;

public class HorsListe extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hors_liste);

    }

    public void retour(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Recherche.class);
        startActivity(intent);
    }


}


