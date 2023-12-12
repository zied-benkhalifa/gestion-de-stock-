package com.example.gs;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;

public class ajoup extends AppCompatActivity {
    SQLiteDatabase mabase;
    Button ajouter;
    EditText nom, categorie, famille, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoup);
        ajouter = (Button) findViewById(R.id.ajouter);
        nom = (EditText) findViewById(R.id.nom);
        categorie = (EditText) findViewById(R.id.categorie);
        famille = (EditText) findViewById(R.id.famille);
        number = (EditText) findViewById(R.id.number);
        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String productName = nom.getText().toString().trim();
                String productCategory = categorie.getText().toString().trim();
                String productFamily = famille.getText().toString().trim();
                int productNumber = Integer.parseInt(number.getText().toString().trim());


                ContentValues contentValues = new ContentValues();
                contentValues.put("nom", productName);
                contentValues.put("dateEmprent", "rien");
                contentValues.put("dateRetour", "rien");
                contentValues.put("categorie", productCategory);
                contentValues.put("famille", productFamily);
                contentValues.put("number", productNumber);

                mabase.insert("produit", null, contentValues);

                // Display a toast indicating the product has been added
                Toast.makeText(ajoup.this, "Produit ajouté avec succès", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
