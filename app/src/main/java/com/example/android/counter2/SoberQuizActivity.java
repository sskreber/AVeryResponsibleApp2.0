package com.example.android.counter2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SoberQuizActivity extends AppCompatActivity {

    // Declares global constants and global variables.

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

    /**
     * Saves user's current soberness score, the values of views which are presently displayed on the screen,
     * and the event counter (how many questions user has been asked already).
     */

    public void onSaveInstanceState(Bundle savedInstanceState) {
        TextView statementTextView = findViewById(R.id.statement);
        statement = statementTextView.getText().toString();
        TextView answerTextView = findViewById(R.id.answer);
        answer = answerTextView.getText().toString();
        TextView buttonTextView = findViewById(R.id.startQuiz);
        buttonText = buttonTextView.getText().toString();
        savedInstanceState.putInt(EVENT_COUNTER, eventCounter);
        savedInstanceState.putInt(SOBER_SCORE, soberScore);
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
            statement = savedInstanceState.getString(STATEMENT_STRING);
            answer = savedInstanceState.getString(ANSWER_STRING);
            buttonText = savedInstanceState.getString(BUTTON_TEXT);
            layoutIsGoHome = savedInstanceState.getBoolean(LAYOUT_IS_GO_HOME);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        } else
            setContentView(R.layout.activity_sober_quiz);
        TextView statementTextView = findViewById(R.id.statement);
        TextView answerTextView = findViewById(R.id.answer);
        statementTextView.setVisibility(View.GONE);
        answerTextView.setVisibility(View.GONE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        eventCounter = 0;
        soberScore = 0;
    }

    /**
     * Gets the values of the two total scores (soberness score; event counter - how many questions user has been asked already),
     * and the values of certain views (question, user's answer, button's text, displayed image view) from the saved states and
     * displays those instead of the default values.
     */

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
            ImageView GoHomeImage = findViewById(R.id.GoHomeImage);
            GoHomeImage.setVisibility(View.VISIBLE);
            TextView statementTextView = findViewById(R.id.statement);
            TextView answerTextView = findViewById(R.id.answer);
            statementTextView.setVisibility(View.GONE);
            answerTextView.setVisibility(View.GONE);
        }
        displayAnswer(answer);
        displayStatement(statement);
        displayButtonWording(buttonText);
    }

    /**
     * Method that runs the soberness quiz and displays a toast message at the end based on the result.
     * If user scores low (less than 3 out of 5), a new image view and new message (via hitherto invisible but now visible views) get displayed,
     * advising user to go home.
     * Is user score high (more than 3 out of 5), they get resent to the Main Activity to be able to continue their drinking, accompanied by a toast message.
     * TODO A bigger quiz question pool and a way to randomize the selection and order of the questions.
     */

    public void startQuiz(View v) {
        TextView startQuizTextView = findViewById(R.id.startQuiz);
        startQuizTextView.setText(getString(R.string.submitAnswer));
        String toastDrunk = getString(R.string.toastDrunk);
        String toastSober = getString(R.string.toastSober);
        eventCounter++;

        if (eventCounter == 1) {
            statement = getString(R.string.operation1);
            answer = getString(R.string.empty);
            buttonText = getString(R.string.submitAnswer);
            TextView statementTextView = findViewById(R.id.statement);
            TextView answerTextView = findViewById(R.id.answer);
            statementTextView.setVisibility(View.VISIBLE);
            answerTextView.setVisibility(View.VISIBLE);
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
            ImageView GoHomeImage = findViewById(R.id.GoHomeImage);
            GoHomeImage.setVisibility(View.VISIBLE);
            layoutIsGoHome = true;
            statement = getString(R.string.empty);
            answer = getString(R.string.empty);
            buttonText = getString(R.string.GoHomeMessage);
            displayStatement(statement);
            displayAnswer(answer);
            displayButtonWording(buttonText);
            TextView statementTextView = findViewById(R.id.statement);
            statementTextView.setVisibility(View.GONE);
            TextView answerTextView = findViewById(R.id.answer);
            answerTextView.setVisibility(View.GONE);
//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
        // Drawable background picture after GoHomeMessage was created by "Burst" at https://www.pexels.com //
    }

    /**
     * A method that gets called every time user clicks the Submit Answer button to submit their solution to the math question.
     * The soberness score is increased upon each submitted correct solution, and stays unchanged when receiving wrong ones.
     */

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

    /**
     * A method that gets called inside the startQuiz method.
     * It changes the displayed math quiz question upon the user's submission of their answer to the next one.
     *
     * @param statement The to-be-displayed upcoming math quiz question.
     */

    public void displayStatement(String statement) {
        TextView statementTextView = findViewById(R.id.statement);
        statementTextView.setText(statement);
    }

    /**
     * A method that gets called inside the startQuiz method.
     * It changes the displayed math quiz answer (an edit text view) to the user's typed in solution.
     *
     * @param answer The user's typed in solution.
     */

    public void displayAnswer(String answer) {
        TextView answerTextView = findViewById(R.id.answer);
        answerTextView.setText(answer);
    }

    /**
     * A method that gets called inside the startQuiz method.
     * It changes the displayed text on the button (start quiz, submit answer, or go home friend, you're drunk) depending on the context.
     *
     * @param buttonText The to-be-displayed wording of the button.
     */

    public void displayButtonWording(String buttonText) {
        TextView buttonTextView = findViewById(R.id.startQuiz);
        buttonTextView.setText(buttonText);
    }

    /**
     * Method that sends user back to Main Activity based if their soberness quiz score was high enough (at least 3 out of 5).
     *
     * @param soberScore User's score (number of correct answers) on the math quiz (soberness quiz).
     *                   getIntent and putExtra lines: Getting from and sending back to Main Activity the alcohol score and water score the user arrived with to the soberness quiz.
     *                   TODO Find a way to make the Main Activity only try to access these scores if a SoberActivity has already been launched and it has sent user back to Main Activity.
     *                   Now it crashes because Main Activity tries to access these intents even if it is launched for the very first time.
     *                   So getIntent has been removed from Main Activity for now to prevent this crash.
     *                   TODO learn more about multi screen apps to fix this.
     */

    public void startMainActivity(int soberScore) {
        Intent mainActivityIntent = new Intent(SoberQuizActivity.this, MainActivity.class);
        int scoreAlcohol = getIntent().getExtras().getInt("scoreAlcohol", 0);
        int scoreSoftDrink = getIntent().getExtras().getInt("scoreSoftDrink", 0);
        mainActivityIntent.putExtra("scoreAlcohol", scoreAlcohol);
        mainActivityIntent.putExtra("scoreSoftDrink", scoreSoftDrink);
        startActivity(mainActivityIntent);
    }
}
