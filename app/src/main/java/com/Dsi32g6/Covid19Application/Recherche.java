package com.Dsi32g6.Covid19Application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Dsi32g6.Covid19Application.Entity.Patient;
import com.Dsi32g6.Covid19Application.Helper.Manager.DbManager;
import com.Dsi32g6.Covid19Application.Helper.UserHelper.AppItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recherche extends AppCompatActivity {
EditText ncin;
    private Object ArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        ncin = findViewById(R.id.cin);
        addListenerOnButton();

    }


  ///////////  //// verifier l'etat de personne /////////////

    public Boolean verifEtat(List<Patient> patient) {
        Boolean v=false;
        for (Patient n :patient)
        {
            v= n.getTest().equals("positive");
        }
        return v;
    }

    public void addListenerOnButton() {
        final DbManager dbManager = new DbManager(this);
        dbManager.open();
        Button button = (Button) findViewById(R.id.trouverp);
        button.setOnClickListener(new View.OnClickListener() {

            private Patient Patient;

            @Override
            public void onClick(View v) {

                String cin = ncin.getText().toString();
                List<Patient> item;
                item = dbManager.trouverPersonne(cin);
                     Patient patient= new Patient();
                   for (Patient n :item) {
                       System.err.println("ttttttttttt"+n.getDateTest());
                   }
       /*         Intent intent = new Intent(getApplicationContext(), ResultatTest.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("Birds", (java.util.ArrayList<? extends Parcelable>) item);
                intent.putExtras(bundle);
                startActivity(intent);

       */
    if(item.isEmpty())
         {
           Intent  intent = new Intent(getApplicationContext(), HorsListe.class);
             startActivity(intent);
         }
    else
         {


                Intent intent = new Intent(getApplicationContext(), ResultatTest.class);
                intent.putExtra("items_to_parse", (Serializable) item);
                startActivityForResult(intent, 0);
         }
            }
        });


    }
}
