package com.example.gs;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class suppM extends AppCompatActivity {
    SQLiteDatabase mabase;
    Button supp;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supp_m);
        supp = (Button) findViewById(R.id.supp);
        id = (EditText) findViewById(R.id.id);
        mabase = openOrCreateDatabase("bd", MODE_PRIVATE, null);

        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String memberId = id.getText().toString().trim();


                Cursor cursor = mabase.rawQuery("SELECT * FROM member WHERE id=?", new String[]{memberId});

                if (cursor.getCount() > 0) {

                    mabase.execSQL("DELETE FROM member WHERE id=?", new Object[]{Integer.parseInt(memberId)});
                    Toast.makeText(suppM.this, "Member with ID " + memberId + " deleted successfully", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(suppM.this, "Member with ID " + memberId + " does not exist", Toast.LENGTH_SHORT).show();
                }


                cursor.close();
            }
        });
    }
}
