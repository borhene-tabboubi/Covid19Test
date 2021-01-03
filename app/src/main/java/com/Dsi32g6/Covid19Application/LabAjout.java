package com.Dsi32g6.Covid19Application;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Dsi32g6.Covid19Application.Helper.Manager.DbManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LabAjout  extends AppCompatActivity {
    ListView lv_panier;
    EditText cin,nom,prenom,periode;
    private Spinner spinner1, spinner2;
    private Button btnSubmit,listbtn;
    SQLiteDatabase db;
    DbManager dbManager;
    public LabAjout() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labo_ajout);
        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        cin =(EditText) findViewById(R.id.cin);
        nom= (EditText)findViewById(R.id.nom);
        prenom =(EditText)findViewById(R.id.prenom);
        periode=(EditText)findViewById(R.id.cf);
    }

    //add items into spinner dynamically
    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("positive");
        list.add("negative");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void retour(View view) {
        Intent intent = new Intent(getApplicationContext(), ListePatient.class);
        startActivity(intent);
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.ajouter);
        listbtn=(Button)findViewById(R.id.retour);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              String etat=String.valueOf(spinner2.getSelectedItem());
                Toast.makeText(LabAjout.this,
                        "Resultat" +
                                "\nSpinner 1 : "+ etat,
                        Toast.LENGTH_SHORT).show();
             String cinV =cin.getText().toString();
             String nomV=nom.getText().toString();
             String prenomV=prenom.getText().toString();
///////////// NEW Date with rigth format //////////////////////////////////////////////////////////////////
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                String date = simpleDateFormat.format(new Date());
                System.err.println(date);
                String dd="2020-01-01";
                Date date1=null;
                try {
                     date1=new SimpleDateFormat("yyyy-MM-dd").parse(dd);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int periodeV=Integer.parseInt(periode.getText().toString());
                db =  openOrCreateDatabase("Covid.DB", Context.MODE_PRIVATE, null);
              //  dbManager.InsertPatient( cinV , nomV , prenomV , periodeV , etat ,date1);
               String addPatient ="INSERT INTO PATIENT  values ('"+cinV+"','"+nomV+"','"+prenomV+"',"+periodeV+",'"+etat+"','"+date+"')";
                db.execSQL(addPatient);
                Intent intent = new Intent(getApplicationContext(), ListePatient.class);
                startActivity(intent);
            }

        });



    }

}


