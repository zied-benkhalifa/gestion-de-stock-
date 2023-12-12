package com.example.gs;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;

public class ajm extends AppCompatActivity {
    Button signupbtn;
    EditText id, username, password;
    SQLiteDatabase mabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajm);

        signupbtn = (Button) findViewById(R.id.signupbtn);
        id = (EditText) findViewById(R.id.id);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String memberId = id.getText().toString().trim();
                String memberUsername = username.getText().toString().trim();
                String memberPassword = password.getText().toString().trim();


                if (memberId.isEmpty() || memberUsername.isEmpty() || memberPassword.isEmpty()) {
                    Toast.makeText(ajm.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {

                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", Integer.parseInt(memberId));
                    contentValues.put("username", memberUsername);
                    contentValues.put("password", memberPassword);

                    mabase.insert("member", null, contentValues);


                    Toast.makeText(ajm.this, "Membre ajouté avec succès", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
