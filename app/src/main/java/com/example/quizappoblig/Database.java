package com.example.quizappoblig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Database extends AppCompatActivity {

    private ArrayList<CatObject> catList;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);


        catList = new ArrayList<>();
        setDefault();

        CustomListAdapter adapter = new CustomListAdapter(this, catList);
        list = (ListView) findViewById(R.id.catListView);
        list.setAdapter(adapter);
    }

    public void setDefault() {
        catList.add(new CatObject("Main Coon", R.drawable.maincoon));
        catList.add(new CatObject("Siamese", R.drawable.siamese));
        catList.add(new CatObject("Sphynx", R.drawable.sphynx));
    }

    public void addCat(View view) {
        String newCatName = getResources().getResourceEntryName(R.id.editCatName);

        catList.add(new CatObject(newCatName, R.id.newCat));
    }

}



