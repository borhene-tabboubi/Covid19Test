package com.Dsi32g6.Covid19Application;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.Dsi32g6.Covid19Application.Entity.Patient;
import com.Dsi32g6.Covid19Application.Helper.DataBaseHelper;
import com.Dsi32g6.Covid19Application.Helper.UserHelper.AppItem;
import com.Dsi32g6.Covid19Application.adapter.ItemAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultatTest extends AppCompatActivity {
    private DataBaseHelper dataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_test);
        TextView cin = (TextView)findViewById(R.id.ncin);
        TextView nom = (TextView)findViewById(R.id.nom);
        TextView prenom = (TextView)findViewById(R.id.prenom);
        TextView test = (TextView)findViewById(R.id.test);
        TextView periodcf = (TextView)findViewById(R.id.periodcf);

        TextView textElement;
        List<Patient> item = this.getIntent().getExtras().getParcelableArrayList("items_to_parse");
        if(item==null)
        {
            Patient items = new Patient();
            items.setCin(items.getCin());
            item.add(items);
            for (Patient n : item) {
                cin.setText(n.getCin());
            }
        }
        else {


            Patient items = new Patient();
            items.setCin(items.getCin());
            items.setNom(items.getNom());
            items.setPrenom(items.getPrenom());
            items.setTest(items.getTest());
            items.setDateTest(items.getDateTest());
            items.setPeriode(items.getPeriode());
            items.setDateString(items.getDateString());
            item.add(items);
            for (Patient n : item) {
                java.util.Date date1 = new java.util.Date();
                System.err.println("hhhhhhhhhhh" + n.getTest());
                System.err.println(convertDateWithFormat(n.getDateString()));
                System.err.println(date1);


                if (DataBaseHelper.diffDate(convertDateWithFormat(n.getDateString()), date1) >= n.getPeriode()) {
                    Long j = DataBaseHelper.diffDate(convertDateWithFormat(n.getDateString()), date1) - n.getPeriode();
                    periodcf.setText("" + n.getPrenom() + " " + n.getNom() + " est Hors Confinement depuis " + j+2+ " Jours");
                } else {
                    Long j = n.getPeriode() - DataBaseHelper.diffDate(convertDateWithFormat(n.getDateString()), date1);
                    periodcf.setText("" + n.getPrenom() + " " + n.getNom() + " est Confiné : Il reste  " + j + " Jours de confinement");

                }


                if (n.getTest().equals("negative")) {
                    test.setTextColor(Color.GREEN);
                    prenom.setText(n.getPrenom());
                    nom.setText(n.getNom());
                    cin.setText(n.getCin());
                    test.setText("Negative");
                    periodcf.setText("" + n.getPrenom() + " " + n.getNom() + getString(R.string.a_testé_le)+n.getDateString()+getString(R.string.negativeResult));
                } else if (n.getTest().equals("positive")) {
                    test.setTextColor(Color.RED);
                    prenom.setText(n.getPrenom());
                    nom.setText(n.getNom());
                    cin.setText(n.getCin());
                    test.setText("Positive");

                } else {
                    cin.setText(n.getCin());

                }

                break;

            }


        }
    }



    public static Date convertDateWithFormat(String dd){

        Date  date1=null;
        try {
            date1=new SimpleDateFormat("yyyy-MM-dd").parse(dd);



        } catch (ParseException e) {
            System.out.println("erreur")  ;
        }
        return date1;
    }
    public void retour(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Recherche.class);
        startActivity(intent);
    }
}
