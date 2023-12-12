package com.example.gs;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class listem extends AppCompatActivity {
    SQLiteDatabase mabase;
    EditText nomEditText, categorieEditText, familleEditText, numberEditText;
    Button ajouterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listem);

        nomEditText = findViewById(R.id.nom);
        categorieEditText = findViewById(R.id.categorie);
        familleEditText = findViewById(R.id.famille);
        numberEditText = findViewById(R.id.number);
        ajouterButton = findViewById(R.id.ajouter);

        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);

        ajouterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifierProduit();
            }
        });
    }

    private void modifierProduit() {
        String nom = nomEditText.getText().toString().trim();
        String categorie = categorieEditText.getText().toString().trim();
        String famille = familleEditText.getText().toString().trim();
        String numberText = numberEditText.getText().toString().trim();


        StringBuilder updateQuery = new StringBuilder("UPDATE produit SET");


        if (!categorie.isEmpty()) {
            updateQuery.append(" categorie = '").append(categorie).append("',");
        }
        if (!famille.isEmpty()) {
            updateQuery.append(" famille = '").append(famille).append("',");
        }
        if (!numberText.isEmpty()) {
            int number = Integer.parseInt(numberText);
            updateQuery.append(" number = ").append(number).append(",");
        }


        if (updateQuery.charAt(updateQuery.length() - 1) == ',') {
            updateQuery.deleteCharAt(updateQuery.length() - 1);
        }


        updateQuery.append(" WHERE nom = '").append(nom).append("'");

        try {
            mabase.execSQL(updateQuery.toString());


            String toastMessage = "Le produit '" + nom + "' a été modifié avec succès.";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(this, "Échec de la modification du produit.", Toast.LENGTH_SHORT).show();
        }
    }
}
