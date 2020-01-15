package com.example.scoreboard2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String STATE_SCORE_1;
    private static String STATE_SCORE_2;
    private TextView boardOne;
    private TextView boardTwo;
    private int scoreOne = 0;
    private int scoreTwo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardOne = findViewById(R.id.scoreOne);
        boardTwo = findViewById(R.id.scoreTwo);
        STATE_SCORE_1 = "valor equipo 1";
        STATE_SCORE_2 = "valor equipo 2";
        if (savedInstanceState != null) {
            scoreOne = savedInstanceState.getInt(STATE_SCORE_1);
            scoreTwo = savedInstanceState.getInt(STATE_SCORE_2);
//Set the score text views
            boardOne.setText(String.valueOf(scoreOne));
            boardTwo.setText(String.valueOf(scoreTwo));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
//Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//Save the scores
        outState.putInt(STATE_SCORE_1, scoreOne);
        outState.putInt(STATE_SCORE_2, scoreTwo);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.night_mode:
                int nm = AppCompatDelegate.getDefaultNightMode();
                if (nm == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
        }
        return true;
    }

    public void increaseScore(View view) {
        boardOne = findViewById(R.id.scoreOne);
        boardTwo = findViewById(R.id.scoreTwo);

        switch (view.getId()) {
            case R.id.plusOne:
                scoreOne++;
                boardOne.setText(String.valueOf(scoreOne));
                break;
            case R.id.plusTwo:
                scoreTwo++;
                boardTwo.setText(String.valueOf(scoreTwo));
                break;
        }
    }

    public void decreaseScore(View view) {
        boardOne = findViewById(R.id.scoreOne);
        boardTwo = findViewById(R.id.scoreTwo);

        switch (view.getId()) {
            case R.id.minusOne:
                scoreOne--;
                boardOne.setText(String.valueOf(scoreOne));
                break;
            case R.id.minusTwo:
                scoreTwo--;
                boardTwo.setText(String.valueOf(scoreTwo));
                break;
        }
    }
}
