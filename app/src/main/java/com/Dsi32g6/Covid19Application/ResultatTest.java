package com.Dsi32g6.Covid19Application;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.Dsi32g6.Covid19Application.Helper.UserHelper.AppItem;
import com.Dsi32g6.Covid19Application.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class ResultatTest extends AppCompatActivity {

    Bundle extra;
    ListView lv_items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_test);
    }
}
