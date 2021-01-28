package com.example.quizappoblig;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Addcat extends AppCompatActivity {

    public static final int GET_FROM_GALLERY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcat);
    }

    public void uploadPicture(View view) {
        startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            ImageView newCat = (ImageView) findViewById(R.id.newCat);
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                newCat.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addCat (View View) {
        Database database = new Database();
        ArrayList<CatObject> catList = database.getCatList();

        //finding new name
        EditText mEdit = (EditText) findViewById(R.id.catNameInput);
        String newCatName = mEdit.getText().toString();

        catList.add(new CatObject(newCatName, R.id.newCat));
        database.setCatList(catList);

        //test
        System.out.println(catList.get(3).getCatName());

        Intent i = new Intent(this, Database.class);
        startActivity(i);
    }


}