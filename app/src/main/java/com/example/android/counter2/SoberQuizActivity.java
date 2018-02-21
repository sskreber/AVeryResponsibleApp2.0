package com.example.android.counter2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SoberQuizActivity extends AppCompatActivity {

    public static final String LAYOUT_IS_GO_HOME = "layoutIsGoHome";
    static final String EVENT_COUNTER = "eventCounter";
    static final String SOBER_SCORE = "soberScore";
    static final String STATEMENT_STRING = "statement";
    static final String ANSWER_STRING = "answer";
    static final String BUTTON_TEXT = "buttonText";
    int eventCounter;
    int soberScore;
    String statement;
    String answer;
    String buttonText;
    boolean layoutIsGoHome;

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Saves user's current scores and the event counter (how many questions user has been asked already)

        TextView statementTextView = (TextView) findViewById(R.id.statement);
        statement = statementTextView.getText().toString();
        TextView answerTextView = (TextView) findViewById(R.id.answer);
        answer = answerTextView.getText().toString();

        TextView buttonTextView = (TextView) findViewById(R.id.startQuiz);
        buttonText = buttonTextView.getText().toString();

        savedInstanceState.putInt(EVENT_COUNTER, eventCounter);
        savedInstanceState.putInt(SOBER_SCORE, soberScore);
//        savedInstanceState.putInt(STATE_ALCOHOL_SCORE, scoreAlcohol);
//        savedInstanceState.putInt(STATE_SOFT_DRINK_SCORE, scoreSoftDrink);
        savedInstanceState.putString(STATEMENT_STRING, statement);
        savedInstanceState.putString(ANSWER_STRING, answer);
        savedInstanceState.putString(BUTTON_TEXT, buttonText);

        savedInstanceState.putBoolean(LAYOUT_IS_GO_HOME, layoutIsGoHome);
        // Calls on the superclass to save the view hierarchy state.
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            setContentView(R.layout.activity_sober_quiz);
            eventCounter = savedInstanceState.getInt(EVENT_COUNTER);
            soberScore = savedInstanceState.getInt(SOBER_SCORE);
//
//            scoreAlcohol = savedInstanceState.getInt(STATE_ALCOHOL_SCORE);
//            scoreSoftDrink = savedInstanceState.getInt(STATE_SOFT_DRINK_SCORE);
            statement = savedInstanceState.getString(STATEMENT_STRING);
            answer = savedInstanceState.getString(ANSWER_STRING);
            buttonText = savedInstanceState.getString(BUTTON_TEXT);
            layoutIsGoHome = savedInstanceState.getBoolean(LAYOUT_IS_GO_HOME);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        } else
            setContentView(R.layout.activity_sober_quiz);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        eventCounter = 0;
        soberScore = 0;
//        scoreAlcohol = savedInstanceState.getInt(STATE_ALCOHOL_SCORE);
//        scoreSoftDrink = savedInstanceState.getInt(STATE_SOFT_DRINK_SCORE);
    }

    // Gets the values of the two total scores for the saved states and displays those instead of the zero default value.

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        eventCounter = savedInstanceState.getInt(EVENT_COUNTER);
        soberScore = savedInstanceState.getInt(SOBER_SCORE);
        statement = savedInstanceState.getString(STATEMENT_STRING);
        answer = savedInstanceState.getString(ANSWER_STRING);
        buttonText = savedInstanceState.getString(BUTTON_TEXT);
        layoutIsGoHome = savedInstanceState.getBoolean(LAYOUT_IS_GO_HOME, false);
        if (layoutIsGoHome) {
            ScrollView layout = findViewById(R.id.ScrollView);
            layout.setBackgroundResource(R.drawable.backgr_drunk_s);
        }

        displayAnswer(answer);
        displayStatement(statement);
        displayButtonWording(buttonText);
    }

    public void startQuiz(View v) {

        TextView startQuizTextView = (TextView) findViewById(R.id.startQuiz);
        startQuizTextView.setText(getString(R.string.submitAnswer));
        String toastDrunk = getString(R.string.toastDrunk);
        String toastSober = getString(R.string.toastSober);

        eventCounter++;

        if (eventCounter == 1) {
            statement = getString(R.string.operation1);
            answer = getString(R.string.empty);
            buttonText = getString(R.string.submitAnswer);
            displayStatement(statement);
            displayAnswer(answer);
            displayButtonWording(buttonText);
            submitAnswer(eventCounter);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }

        if (eventCounter == 2) {
            submitAnswer(eventCounter);
            statement = getString(R.string.operation2);
            answer = getString(R.string.empty);
            displayStatement(statement);
            displayAnswer(answer);
            displayButtonWording(buttonText);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
        if (eventCounter == 3) {
            submitAnswer(eventCounter);
            statement = getString(R.string.operation3);
            answer = getString(R.string.empty);
            buttonText = getString(R.string.submitAnswer);
            displayStatement(statement);
            displayAnswer(answer);
            displayButtonWording(buttonText);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }

        if (eventCounter == 4) {
            submitAnswer(eventCounter);
            statement = getString(R.string.operation4);
            answer = getString(R.string.empty);
            buttonText = getString(R.string.submitAnswer);
            displayStatement(statement);
            displayAnswer(answer);
            displayButtonWording(buttonText);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }

        if (eventCounter == 5) {
            submitAnswer(eventCounter);
            statement = getString(R.string.operation5);
            answer = getString(R.string.empty);
            buttonText = getString(R.string.submitAnswer);
            displayStatement(statement);
            displayAnswer(answer);
            displayButtonWording(buttonText);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }

        if (eventCounter >= 6 && soberScore >= 3) {
            Toast.makeText(getApplicationContext(), toastSober, Toast.LENGTH_LONG).show();
            startMainActivity(soberScore);
        } else if (eventCounter >= 6 && soberScore < 3) {
            Toast.makeText(getApplicationContext(), toastDrunk, Toast.LENGTH_LONG).show();
            ScrollView layout = findViewById(R.id.ScrollView);
            layout.setBackgroundResource(R.drawable.backgr_drunk_s);
            layoutIsGoHome = true;

            statement = getString(R.string.empty);
            answer = getString(R.string.empty);
            buttonText = getString(R.string.GoHomeMessage);
            displayStatement(statement);
            displayAnswer(answer);
            displayButtonWording(buttonText);

            TextView statementTextView = (TextView) findViewById(R.id.statement);
            statementTextView.setVisibility(View.GONE);
            TextView answerTextView = (TextView) findViewById(R.id.answer);
            answerTextView.setVisibility(View.GONE);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }

        // Drawable background picture after GoHomeMessage was created by "Burst" at https://www.pexels.com //

//            startQuizTextView.setText(soberScore);
    }

    public void submitAnswer(int eventCounter) {
        EditText answerText = findViewById(R.id.answer);
        String answer = answerText.getText().toString();
        if (eventCounter >= 1) {
            if (answer.equals(getString(R.string.op1correct))) {
                soberScore++;
            }
        }
        if (eventCounter >= 2) {
            if (answer.equals(getString(R.string.op2correct))) {
                soberScore++;
            }
        }

        if (eventCounter >= 3) {
            if (answer.equals(getString(R.string.op3correct))) {
                soberScore++;
            }
        }

        if (eventCounter >= 4) {
            if (answer.equals(getString(R.string.op4correct))) {
                soberScore++;
            }
        }

        if (eventCounter >= 5) {
            if (answer.equals(getString(R.string.op5correct))) {
                soberScore++;
            }
        }
    }

    public void displayStatement(String statement) {
        TextView statementTextView = (TextView) findViewById(R.id.statement);
        statementTextView.setText(statement);
    }

    public void displayAnswer(String answer) {
        TextView answerTextView = (TextView) findViewById(R.id.answer);
        answerTextView.setText(answer);
    }

    public void displayButtonWording(String buttonText) {
        TextView buttonTextView = (TextView) findViewById(R.id.startQuiz);
        buttonTextView.setText(buttonText);
    }

    public void startMainActivity(int soberScore) {
        Intent mainActivityIntent = new Intent(SoberQuizActivity.this, MainActivity.class);
        int scoreAlcohol = getIntent().getExtras().getInt("scoreAlcohol", 0);
        int scoreSoftDrink = getIntent().getExtras().getInt("scoreSoftDrink", 0);
        // Go back to main activity to enable user to go back to drinking and keeping score of it //
        startActivity(mainActivityIntent);
    }
}
