package com.example.android.counter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declares global constants, setting the two variables storing a total score each as such.

    static final String STATE_ALCOHOL_SCORE = "scoreAlcohol";
    static final String STATE_SOFT_DRINK_SCORE = "scoreSoftDrink";

    /**
     * Initializes a variable that tracks the total score of alcohol already consumed by user.
     * This variable will later on be set not to go below 0.
     */

    int scoreAlcohol;

    /**
     * Initializes a variable that tracks the total score of NEEDED soft drink consumption for user.
     * This variable CAN go below zero (user can drink some soft drinks ahead and thus be rewarded with less
     * soft drink needed to be drank points with alcohol consumption.
     */

    int scoreSoftDrink;

    // Pulls the content of Strings to toast messages.

    /**
     * Pulls out the value for the two total scores, alcohol consumption and needed soft drink consumption,
     * and saves their values.
     */

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Saves user's current scores.
        savedInstanceState.putInt(STATE_ALCOHOL_SCORE, scoreAlcohol);
        savedInstanceState.putInt(STATE_SOFT_DRINK_SCORE, scoreSoftDrink);
        // Calls on the superclass to save the view hierarchy state.
        super.onSaveInstanceState(savedInstanceState);
    }

    // Continues or starts activity after checking if there was an ongoing saved activity to reload or not.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            setContentView(R.layout.activity_main);
            scoreAlcohol = savedInstanceState.getInt(STATE_ALCOHOL_SCORE);
            scoreSoftDrink = savedInstanceState.getInt(STATE_SOFT_DRINK_SCORE);
        } else
            setContentView(R.layout.activity_main);
        scoreAlcohol = 0;
        scoreSoftDrink = 0;
    }

    // Gets the values of the two total scores for the saved states and displays those instead of the zero default value.

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreAlcohol = savedInstanceState.getInt(STATE_ALCOHOL_SCORE);
        scoreSoftDrink = savedInstanceState.getInt(STATE_SOFT_DRINK_SCORE);
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    // Inflates the menu.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Increases the score for alcohol consumed by 1 point, and displays toast messages accordingly.

    public void addOneForAlcohol(View v) {
        scoreAlcohol++;
        scoreSoftDrink++;
        String toastAddForAlcohol_0 = getString(R.string.toastAddForAlcohol_0);
        String toastAddForAlcohol_1 = getString(R.string.toastAddForAlcohol_1);
        String toastAddForAlcohol_2 = getString(R.string.toastAddForAlcohol_2);
        String toastAddForAlcohol_3 = getString(R.string.toastAddForAlcohol_3);
        String toastAddForAlcohol_4 = getString(R.string.toastAddForAlcohol_4);
        String toastAddForAlcohol_5 = getString(R.string.toastAddForAlcohol_5);
        String toastAddForAlcohol_6 = getString(R.string.toastAddForAlcohol_6);
        String toastAddForAlcohol_7 = getString(R.string.toastAddForAlcohol_7);
        String toastAddForAlcohol_8 = getString(R.string.toastAddForAlcohol_8);
        String toastAddForAlcohol_9 = getString(R.string.toastAddForAlcohol_9);
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
        if (scoreAlcohol == 1) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_0, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol == 3) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_1, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol == 2 || scoreAlcohol == 4) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_2, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol == 6) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_3, Toast.LENGTH_SHORT).show();
            // keep varying messages here based on water intake as alcohol level increases.
        } else if (scoreAlcohol > 6 && scoreAlcohol < 10 && scoreSoftDrink <= 4 && scoreAlcohol % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_4, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol > 6 && scoreAlcohol < 10 && scoreSoftDrink <= 4 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_5, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol > 6 && scoreAlcohol < 10 && scoreSoftDrink > 4 && scoreAlcohol % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_6, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol > 6 && scoreAlcohol < 10 && scoreSoftDrink > 4 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_7, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol >= 10 && scoreAlcohol < 15 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_8, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol >= 10 && scoreAlcohol < 15 && scoreAlcohol % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_9, Toast.LENGTH_SHORT).show();
        }
    }

    // Increases the score for alcohol consumed by 3 points, and displays toast messages accordingly.

    public void addThreeForAlcohol(View v) {
        scoreAlcohol = scoreAlcohol + 3;
        scoreSoftDrink = scoreSoftDrink + 3;
        String toastAddForAlcohol_1 = getString(R.string.toastAddForAlcohol_1);
        String toastAddForAlcohol_2 = getString(R.string.toastAddForAlcohol_2);
        String toastAddForAlcohol_3 = getString(R.string.toastAddForAlcohol_3);
        String toastAddForAlcohol_4 = getString(R.string.toastAddForAlcohol_4);
        String toastAddForAlcohol_5 = getString(R.string.toastAddForAlcohol_5);
        String toastAddForAlcohol_6 = getString(R.string.toastAddForAlcohol_6);
        String toastAddForAlcohol_7 = getString(R.string.toastAddForAlcohol_7);
        String toastAddForAlcohol_8 = getString(R.string.toastAddForAlcohol_8);
        String toastAddForAlcohol_9 = getString(R.string.toastAddForAlcohol_9);
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
        if (scoreAlcohol == 3) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_1, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol == 2 || scoreAlcohol == 4) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_2, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol == 6) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_3, Toast.LENGTH_SHORT).show();
            // keeps displaying various messages based on water intake as alcohol level increases.
        } else if (scoreAlcohol > 6 && scoreAlcohol < 10 && scoreSoftDrink <= 4 && scoreAlcohol % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_4, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol > 6 && scoreAlcohol < 10 && scoreSoftDrink <= 4 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_5, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol > 6 && scoreAlcohol < 10 && scoreSoftDrink > 4 && scoreAlcohol % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_6, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol > 6 && scoreAlcohol < 10 && scoreSoftDrink > 4 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_7, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol >= 10 && scoreAlcohol < 15 && scoreAlcohol % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_8, Toast.LENGTH_SHORT).show();
        } else if (scoreAlcohol >= 10 && scoreAlcohol < 15 && scoreAlcohol % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastAddForAlcohol_9, Toast.LENGTH_SHORT).show();
        }
    }

    // Method that decreases the score for alcohol consumed by 1 point, and displays toast messages accordingly.

    public void subtractOneForAlcohol(View v) {
        if (scoreAlcohol > 0) {
            scoreAlcohol--;
            scoreSoftDrink = scoreSoftDrink--;
        } else {
            scoreAlcohol = 0;
        }
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    // Method that decreases the score for alcohol consumed by 3 points, and displays toast messages accordingly.

    public void subtractThreeForAlcohol(View v) {
        if (scoreAlcohol >= 3) {
            scoreAlcohol = scoreAlcohol - 3;
            scoreSoftDrink = scoreSoftDrink - 3;
        }
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    /**
     * Method that displays the total score for the alcohol consumed (in made-up units).
     * Signifies the amount of alcohol user already consumed.
     * User should keep it low.
     *
     * @param alcScore User's current alcohol score (alcohol consumed).
     */
    public void displayForAlcohol(int alcScore) {
        TextView scoreView = findViewById(R.id.alcohol_score);
        scoreView.setText(String.valueOf(alcScore));
        if (scoreAlcohol > 12) {
            startSoberQuiz(scoreAlcohol);
        }
    }

    // Method that increases the score for needed soft drink consumption by 1 point.

    public void addOneForSoftDrink(View v) {
        scoreSoftDrink++;
        displayForSoftDrink(scoreSoftDrink);
    }

    // Method that increases the score for alcohol consumed by 2 points.

    public void addTwoForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink + 2;
        displayForSoftDrink(scoreSoftDrink);
    }

    // Method that decreases the score for needed soft drink consumption by 1 point, and displays toast messages accordingly.

    public void subtractOneForSoftDrink(View v) {
        scoreSoftDrink--;
        String toastSubtractForSoftDrink_1 = getString(R.string.toastSubtractForSoftDrink_1);
        String toastSubtractForSoftDrink_2 = getString(R.string.toastSubtractForSoftDrink_2);
        String toastSubtractForSoftDrink_3 = getString(R.string.toastSubtractForSoftDrink_3);
        String toastSubtractForSoftDrink_4 = getString(R.string.toastSubtractForSoftDrink_4);
        String toastSubtractForSoftDrink_5 = getString(R.string.toastSubtractForSoftDrink_5);
        String toastSubtractForSoftDrink_6 = getString(R.string.toastSubtractForSoftDrink_6);
        String toastSubtractForSoftDrink_7 = getString(R.string.toastSubtractForSoftDrink_7);
        String toastSubtractForSoftDrink_8 = getString(R.string.toastSubtractForSoftDrink_8);
        String toastSubtractForSoftDrink_9 = getString(R.string.toastSubtractForSoftDrink_9);
        displayForSoftDrink(scoreSoftDrink);
        if (scoreSoftDrink > 11) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_1, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 11 && scoreSoftDrink > 8 && scoreSoftDrink % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_2, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 11 && scoreSoftDrink > 8 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_3, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol >= 7 && scoreSoftDrink % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_4, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol >= 7 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_5, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol < 7 && scoreAlcohol > 3 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_6, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol < 7 && scoreAlcohol > 3 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_7, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol <= 3 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_8, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol <= 3 && scoreSoftDrink % 2 == 1 || scoreSoftDrink % 2 == -1) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_9, Toast.LENGTH_SHORT).show();
        }
    }

    // Method that decreases the score for needed soft drink consumption by 2 points, and displays toast messages accordingly.

    public void subtractTwoForSoftDrink(View v) {
        scoreSoftDrink = scoreSoftDrink - 2;
        String toastSubtractForSoftDrink_1 = getString(R.string.toastSubtractForSoftDrink_1);
        String toastSubtractForSoftDrink_2 = getString(R.string.toastSubtractForSoftDrink_2);
        String toastSubtractForSoftDrink_3 = getString(R.string.toastSubtractForSoftDrink_3);
        String toastSubtractForSoftDrink_4 = getString(R.string.toastSubtractForSoftDrink_4);
        String toastSubtractForSoftDrink_5 = getString(R.string.toastSubtractForSoftDrink_5);
        String toastSubtractForSoftDrink_6 = getString(R.string.toastSubtractForSoftDrink_6);
        String toastSubtractForSoftDrink_7 = getString(R.string.toastSubtractForSoftDrink_7);
        String toastSubtractForSoftDrink_8 = getString(R.string.toastSubtractForSoftDrink_8);
        String toastSubtractForSoftDrink_9 = getString(R.string.toastSubtractForSoftDrink_9);
        displayForSoftDrink(scoreSoftDrink);
        if (scoreSoftDrink > 11) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_1, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 11 && scoreSoftDrink > 8 && scoreSoftDrink % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_2, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 11 && scoreSoftDrink > 8 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_3, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol >= 7 && scoreSoftDrink % 2 == 1) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_4, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol >= 7 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_5, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol < 7 && scoreAlcohol > 3 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_6, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol < 7 && scoreAlcohol > 3 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_7, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol <= 3 && scoreSoftDrink % 2 == 0) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_8, Toast.LENGTH_SHORT).show();
        } else if (scoreSoftDrink < 8 && scoreAlcohol <= 3 && scoreSoftDrink % 2 == 1 || scoreSoftDrink % 2 == -1) {
            Toast.makeText(getApplicationContext(), toastSubtractForSoftDrink_9, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method that displays the total score for soft drinks (in made-up units).
     * Signifies the amount of soft drinks user still needs to drink.
     * User should keep it low.
     *
     * @param waterScore User's current water/softDrink score (units consumed).
     */

    public void displayForSoftDrink(int waterScore) {
        TextView scoreView = findViewById(R.id.soft_drink_score);
        scoreView.setText(String.valueOf(waterScore));
        if (scoreAlcohol > 12) {
            startSoberQuiz(scoreAlcohol);
        }
    }

    // Resets the score for both the alcohol and soft drink score to 0.

    public void resetScore(View v) {
        scoreAlcohol = 0;
        scoreSoftDrink = 0;
        displayForAlcohol(scoreAlcohol);
        displayForSoftDrink(scoreSoftDrink);
    }

    // If the alcohol score gets high (i.e. reaches 13), a new activity starts: user is sent to a quiz testing soberness (or cognitive functions left).

    public void startSoberQuiz(int scoreAlcohol) {
        Intent soberQuizIntent = new Intent(MainActivity.this, SoberQuizActivity.class);
        // Start the new activity
        soberQuizIntent.putExtra("scoreAlcohol", scoreAlcohol);
        soberQuizIntent.putExtra("scoreSoftDrink", scoreSoftDrink);
        startActivity(soberQuizIntent);
    }
}