package com.example.gs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class choisir extends AppCompatActivity {
    SQLiteDatabase mabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir);
        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);


        Intent intent = getIntent();
        String selectedCategory = intent.getStringExtra("selectedCategory");
        String selectedSubCategory = intent.getStringExtra("selectedSubCategory");


        TextView categoryTextView = findViewById(R.id.categoryTextView);
        TextView subCategoryTextView = findViewById(R.id.subCategoryTextView);

        categoryTextView.setText("Selected Category: " + selectedCategory);
        subCategoryTextView.setText("Selected SubCategory: " + selectedSubCategory);


        EditText numberEditText = findViewById(R.id.nembre);
        EditText dateEmpruntEditText = findViewById(R.id.dateemprunt);
        EditText dateRetourEditText = findViewById(R.id.dateretour);
        EditText idMemberEditText = findViewById(R.id.idmember);


        Button okButton = findViewById(R.id.okButton);


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = numberEditText.getText().toString();
                String dateEmprunt = dateEmpruntEditText.getText().toString();
                String dateRetour = dateRetourEditText.getText().toString();
                String idMember = idMemberEditText.getText().toString();


                String insertQuery = "INSERT INTO reserver (category, subcategory, number, dateEmprunt, dateRetour, idmember) " +
                        "VALUES ('" + selectedCategory + "', '" + selectedSubCategory + "', " + number + ", '" + dateEmprunt + "', '" + dateRetour + "', " + idMember + ");";

                mabase.execSQL(insertQuery);


                Toast.makeText(choisir.this, "Ta commande est réservée", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
