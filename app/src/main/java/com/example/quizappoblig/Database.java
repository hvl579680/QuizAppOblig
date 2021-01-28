package com.example.quizappoblig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
        String newCatName = getResources().getResourceEntryName(R.id.catNameInput);

        catList.add(new CatObject(newCatName, R.id.newCat));
    }

    public ArrayList<CatObject> getCatList() {
        catList = new ArrayList<>();
        catList.add(new CatObject("Main Coon", R.drawable.maincoon));
        catList.add(new CatObject("Siamese", R.drawable.siamese));
        catList.add(new CatObject("Sphynx", R.drawable.sphynx));
        return catList;
    }

    public void setCatList(ArrayList<CatObject> newList) {
        this.catList = newList;
    }

    public void deleteCat(View View) {
        System.out.println("test");
    }

}



