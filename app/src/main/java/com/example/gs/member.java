package com.example.gs;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class member extends AppCompatActivity {

    private Spinner categorySpinner;
    private Spinner subCategorySpinner;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        categorySpinner = findViewById(R.id.categorySpinner);
        subCategorySpinner = findViewById(R.id.subCategorySpinner);
        okButton = findViewById(R.id.okButton);


        String[] categories = {"Cartes", "Livres", "Capteurs"};
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);


        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateSubCategorySpinner(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCategory = categorySpinner.getSelectedItem().toString();
                String selectedSubCategory = subCategorySpinner.getSelectedItem().toString();

                // Perform actions with selected category and sub-category
                Toast.makeText(member.this, "Selected Category: " + selectedCategory + "\nSelected SubCategory: " + selectedSubCategory, Toast.LENGTH_SHORT).show();
                // Créer l'intent et y ajouter les données
                Intent intent = new Intent(member.this, choisir.class);
                intent.putExtra("selectedCategory", selectedCategory);
                intent.putExtra("selectedSubCategory", selectedSubCategory);

                // Démarrer la nouvelle activité
                startActivity(intent);
            }
        });
    }

    private void updateSubCategorySpinner(int categoryPosition) {
        String[] subCategories;
        switch (categoryPosition) {
            case 0:
                subCategories = new String[]{"ESP32", "Arduino", "Raspberry"};
                break;
            case 1:
                subCategories = new String[]{"HTML Beginner", "JavaScript Beginner"};
                break;
            case 2:
                subCategories = new String[]{"DHT11", "DHT22", "BMP280"};
                break;
            default:
                subCategories = new String[0];
                break;
        }

        ArrayAdapter<String> subCategoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subCategories);
        subCategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subCategorySpinner.setAdapter(subCategoryAdapter);
    }
}
