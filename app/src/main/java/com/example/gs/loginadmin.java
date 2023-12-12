package com.example.gs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginadmin extends AppCompatActivity {
    SQLiteDatabase mabase;
    Button loginbtna;
    EditText usernamea, passworda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginadmin);
        loginbtna = findViewById(R.id.loginbtna);
        usernamea = findViewById(R.id.usernamea);
        passworda = findViewById(R.id.passworda);
        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);
        Log.d("TAG", "onCreate: " + mabase.getPath());


        Cursor c2=mabase.rawQuery("select * from admin",null);
        if(c2.getCount()==0){
            mabase.execSQL("insert into admin(id,username,password) values (111,'zied','zied123');");
            mabase.execSQL("insert into admin(id,username,password) values (988,'Oussema','Oussema');");
        }

        loginbtna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernamea.getText().toString();
                String password = passworda.getText().toString();

                Cursor cursor = mabase.rawQuery("SELECT * FROM admin WHERE username=? AND password=?",
                        new String[]{username, password});

                if (cursor.getCount() == 0) {

                    Toast.makeText(loginadmin.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                } else {

                    Intent i3 = new Intent(loginadmin.this, admin.class);
                    startActivity(i3);
                }


                cursor.close();
            }
        });
    }
}
