package com.example.quizappoblig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Database extends AppCompatActivity {

    int[] images = {
            R.drawable.sphynx,
            R.drawable.siamese,
            R.drawable.maincoon
    };

    String[] catRaces = {
            "Sphynx",
            "Siamese",
            "Main coon"
    };

    ListView lView;

    ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        lView = (ListView) findViewById(R.id.androidList);

        lAdapter = new ListAdapter(Database.this, catRaces, images);

        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Database.this, catRaces[i], Toast.LENGTH_LONG).show();
            }
        });
    }
}