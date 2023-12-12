package com.example.gs;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {
    SQLiteDatabase mabase;
Button ajouterm,suppm,supp,ajouterp,modifier,afficher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ajouterm=(Button) findViewById(R.id.ajouterm);
        suppm=(Button) findViewById(R.id.suppm);
        supp=(Button) findViewById(R.id.supp);
        ajouterp=(Button) findViewById(R.id.ajouterp);
        modifier=(Button) findViewById(R.id.modifier);
        afficher=(Button) findViewById(R.id.afficher);
        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);

        Cursor c5=mabase.rawQuery("select * from produit",null);
        if(c5.getCount()==0){

            mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('esp32','rien','rien','esp32','carte',5);");
            mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('esp32cam','rien','rien','esp32','carte',3);");
            mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('esp32S','rien','rien','esp32','carte',2);");
            mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('arduinoUno','rien','rien','arduino','carte',7);");
            mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('rasberryPi4','rien','rien','rasberry','carte',5);");
            mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('rasberryPico','rien','rien','rasberry','carte',1);");
           mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('htmlBeginer','rien','rien','html','livre',3);");
           mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('JavaBeginer','rien','rien','java','livre',2);");
           mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('dht22','rien','rien','dht','capteur',3);");
           mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('dht11','rien','rien','dht','capteur',7);");
            mabase.execSQL("INSERT INTO produit (nom,dateEmprent,dateRetour,categorie,famille,number) values ('bmp280','rien','rien','bmp','capteur',4);");








        }

        ajouterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(admin.this, ajm.class);
                startActivity(i6);
            }
        });
        suppm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7=new Intent(admin.this,suppM.class);
                startActivity(i7);
            }
        });
        ajouterp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8 =new Intent(admin.this,ajoup.class);
                startActivity(i8);
            }
        });
        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i9=new Intent(admin.this,supP.class);
                startActivity(i9);
            }
        });
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i10=new Intent(admin.this, listem.class);
            startActivity(i10);
            }
        });
        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i11=new Intent(admin.this, afficher.class);
                startActivity(i11);
            }
        });



    }

}
