package com.example.gs;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;

public class createmember extends AppCompatActivity {
    Button signupbtn;
    EditText id, username, password;
    SQLiteDatabase mabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createmember);

        signupbtn = (Button) findViewById(R.id.signupbtn);
        id = (EditText) findViewById(R.id.id);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String memberId = id.getText().toString();
                String memberUsername = username.getText().toString();
                String memberPassword = password.getText().toString();


                if (memberId.isEmpty() || memberUsername.isEmpty() || memberPassword.isEmpty()) {
                    Toast.makeText(createmember.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {

                    if (isIdExists(Integer.parseInt(memberId))) {
                        Toast.makeText(createmember.this, "Ce compte existe déjà", Toast.LENGTH_SHORT).show();
                    } else {

                        String insertQuery = "INSERT INTO member (id, username, password) VALUES (?, ?, ?)";
                        try {
                            mabase.execSQL(insertQuery, new Object[]{Integer.parseInt(memberId), memberUsername, memberPassword});


                            Toast.makeText(createmember.this, "Membre créé avec succès", Toast.LENGTH_SHORT).show();


                            Intent i5 = new Intent(createmember.this, adminmember.class);
                            startActivity(i5);
                        } catch (Exception e) {
                            Toast.makeText(createmember.this, "Erreur lors de l'insertion", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }


    private boolean isIdExists(int memberId) {
        Cursor cursor = mabase.rawQuery("SELECT * FROM member WHERE id = ?", new String[]{String.valueOf(memberId)});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}
