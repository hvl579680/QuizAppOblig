package com.example.quizappoblig;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void databaseView (View View) {
        Intent i = new Intent (this, Database.class);
        startActivity(i);
    }

    //public void quizView (View View) {
    //    Intent i = new Intent (this, Quiz.class);
    //    startActivity(i);
    //}

    //public void addcatView (View View) {
    //    Intent i = new Intent (this, Addcat.class);
    //    startActivity(i);
    //}
}