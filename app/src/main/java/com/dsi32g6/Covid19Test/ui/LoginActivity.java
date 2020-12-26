package com.dsi32g6.Covid19Test.ui;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dsi32g6.Covid19Test.R;

public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText pwd;
    Button btlogin;
    DbManager dbManager;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.username1);
        pwd = (EditText) findViewById(R.id.password1);
        btlogin = (Button) findViewById(R.id.btnsignin1);
        dbManager = new DbManager(this);
        dbManager.open();
    }

    private Boolean verify(String username, String password) {
        if (username != null && password != null) {
            if (!username.equals("") && !password.equals("")) {
                return true;
            }
        }
        return false;
    }

    private Boolean authenticate(String username, String password) {
        return dbManager.authenticate(username,password);
    }


    public void login(View view) {
        String username = email.getText().toString();
        String password = pwd.getText().toString();

        if (!verify(password, password)) {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_LONG).show();
            return;
        }

        if (!authenticate(username, password)) {
            Toast.makeText(this, "Username or password wrong!", Toast.LENGTH_LONG).show();
            return;
        }


        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}

