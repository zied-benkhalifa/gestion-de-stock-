package com.example.gs;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class afficher extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher);

        dbHelper = new DatabaseHelper(this);


        List<Member> members = getMembers();
        TextView memberTextView = findViewById(R.id.memberTextView);

        for (Member member : members) {
            memberTextView.append("ID: " + member.getId() + ", Username: " + member.getUsername() + "\n");
        }
    }

    private List<Member> getMembers() {
        List<Member> members = new ArrayList<>();
        SQLiteDatabase mabase = dbHelper.getReadableDatabase();

        String[] projection = {"id", "username"};
        Cursor cursor = mabase.query("member", projection, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex("id");
            int usernameIndex = cursor.getColumnIndex("username");

            do {
                if (idIndex != -1 && usernameIndex != -1) {
                    int id = cursor.getInt(idIndex);
                    String username = cursor.getString(usernameIndex);
                    members.add(new Member(id, username));
                }
            } while (cursor.moveToNext());

            cursor.close();
        } else {
            Log.d("Database", "No data found in the member table");
        }

        mabase.close();
        return members;
    }
}
