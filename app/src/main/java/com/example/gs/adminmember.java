package com.example.gs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminmember extends AppCompatActivity {
Button createbtnm,loginbtnm;
EditText usernamem,passwordm;
    SQLiteDatabase mabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmember);
        loginbtnm=(Button) findViewById(R.id.loginbtnm);
        createbtnm=(Button) findViewById(R.id.createbtnm);
        passwordm=(EditText) findViewById(R.id.passwordm);
        usernamem=(EditText) findViewById(R.id.usernamem);
        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);

        Cursor c3=mabase.rawQuery("select * from member",null);
        if(c3.getCount()==0){
            mabase.execSQL("INSERT INTO member(id,username,password) values (222,'sabrine','sabrine123');");
        }
        loginbtnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernamem.getText().toString();
                String password = passwordm.getText().toString();

                Cursor cursor = mabase.rawQuery("SELECT * FROM member WHERE username=? AND password=?",
                        new String[]{username, password});

                if (cursor.getCount() == 0) {

                    Toast.makeText(adminmember.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                } else {

                    Intent i3 = new Intent(adminmember.this, member.class);
                    startActivity(i3);
                }


                cursor.close();
            }
        });










        createbtnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4= new Intent(adminmember.this, createmember.class);
                startActivity(i4);
            }
        });
    }
}