package com.example.gs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button admin,member;
    SQLiteDatabase mabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin=(Button) findViewById(R.id.admin);
        member=(Button) findViewById(R.id.member);
        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);
        mabase.execSQL("CREATE TABLE IF NOT EXISTS member (id integer primary key , username varchar,password varchar) ;");
        mabase.execSQL("CREATE TABLE IF NOT EXISTS admin (id integer primary key , username varchar,password varchar) ;");
        mabase.execSQL("CREATE TABLE IF NOT EXISTS produit (nom varchar primary key , dateEmprent varchar,dateRetour varchar,categorie varchar,famille varchar ,number integer) ;");
        mabase.execSQL("CREATE TABLE IF NOT EXISTS reserver (category varchar, subcategory varchar, number integer, dateEmprunt varchar, dateRetour varchar, idmember integer);");

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,loginadmin.class);
                startActivity(i1);
            }
        });
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,adminmember.class);
                startActivity(i2);
            }
        });
    }
}