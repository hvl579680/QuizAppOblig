package com.example.quizappoblig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    public ArrayList<CatObject> catList;
    public CatObject currentCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        showCat();
    }

    public void showCat () {
        //get list
        Database database = new Database();
        catList = database.getCatList();

        //choose random cat
        currentCat = getRandomElement(catList);
        ImageView guessCat = (ImageView) findViewById(R.id.catQuiz);
        guessCat.setImageResource(currentCat.getImageName());
    }

    public boolean submitFunc(View View) {
        EditText guessedCat = (EditText) findViewById(R.id.CatRaceQuizInput);
        String answer = guessedCat.getText().toString();

        String fasit = currentCat.getCatName();

        //compare answer
        boolean result = answer.equalsIgnoreCase(fasit);

        TextView scoreText = (TextView) findViewById(R.id.scoreText);

        //result
        if (result) {
            scoreText.setText("Correct!");
        } else {
            scoreText.setText("Wrong!");
        }

        //next cat

        return result;
    }

    public CatObject getRandomElement(ArrayList<CatObject> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }


}