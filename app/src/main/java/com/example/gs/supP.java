package com.example.gs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class supP extends AppCompatActivity {
    EditText nom;
    Button supp;
    SQLiteDatabase mabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sup_p);
        nom = (EditText) findViewById(R.id.nom);
        supp = (Button) findViewById(R.id.supp);
        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);

        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String productName = nom.getText().toString().trim();


                Cursor cursor = mabase.rawQuery("SELECT * FROM produit WHERE nom=?", new String[]{productName});

                if (cursor.getCount() > 0) {

                    mabase.execSQL("DELETE FROM produit WHERE nom=?", new Object[]{productName});
                    Toast.makeText(supP.this, "Produit avec le nom " + productName + " supprimé avec succès", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(supP.this, "Produit avec le nom " + productName + " n'existe pas", Toast.LENGTH_SHORT).show();
                }


                cursor.close();
            }
        });
    }
}
