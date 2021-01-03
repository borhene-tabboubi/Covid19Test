package com.Dsi32g6.Covid19Application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.Dsi32g6.Covid19Application.Helper.Manager.DbManager;

public class MainActivity extends AppCompatActivity {

    DbManager dbManager;
    SQLiteDatabase db;

    EditText email;
    EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DbManager(this);
        dbManager.open();

        email = findViewById(R.id.edt_txt_login_id);
        pwd = findViewById(R.id.edt_txt_password);

           }



    private Boolean verify(String username, String password) {
        if (username != null && password != null) {
            return !username.equals("") && !password.equals("");
        }
        return false;
    }

    private Boolean authenticate(String username, String password) {
        return dbManager.authenticate(username,password);
    }


    public void login(View view)
    {
        String username = email.getText().toString();
        String password = pwd.getText().toString();

      //  String  profile_counts = DataBaseHelper.getProfilesCount(username,password);

        if (!verify(password, password)) {
            Toast.makeText(this, "Champs vides", Toast.LENGTH_LONG).show();
            return;
        }

        if (!authenticate(username, password)) {
            Toast.makeText(this, "Identifiant ou mot de passe invalide", Toast.LENGTH_LONG).show();
            return;
        }

        String test=dbManager.getUserRole(username,password);
        Intent intent;
        if (test.equals("p"))
        {
            intent = new Intent(this, Recherche.class);
        }
        else
        {
            intent = new Intent(this, LabAjout.class);
        }
        startActivity(intent);

    }

}

