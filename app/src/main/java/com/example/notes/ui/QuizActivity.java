package com.example.notes.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notes.R;
import com.google.android.material.button.MaterialButton;

public class QuizActivity extends AppCompatActivity {
    private TextView questionText;
    private MaterialButton[] optionButtons = new MaterialButton[3];
    private Button nextButton;
    
    private int currentQuestionIndex = 0;
    
    private String[] questions = {
        "What is the capital of France?",
        "What is 5 + 5?",
        "Who wrote Java?"
    };
    
    private String[][] options = {
        {"Berlin", "Paris", "Madrid"},
        {"10", "15", "20"},
        {"Steve Jobs", "James Gosling", "Bill Gates"}
    };
    
    private int[] correctAnswers = {1, 0, 1};

    private static final String KEY_INDEX = "quiz_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.text_view_question);
        optionButtons[0] = findViewById(R.id.button_option1);
        optionButtons[1] = findViewById(R.id.button_option2);
        optionButtons[2] = findViewById(R.id.button_option3);
        nextButton = findViewById(R.id.button_next);

        if (savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt(KEY_INDEX);
        }

        updateQuestion();

        for (int i = 0; i < optionButtons.length; i++) {
            final int index = i;
            optionButtons[i].setOnClickListener(v -> checkAnswer(index));
        }

        nextButton.setOnClickListener(v -> {
            currentQuestionIndex = (currentQuestionIndex + 1) % questions.length;
            updateQuestion();
        });
    }

    private void updateQuestion() {
        questionText.setText(questions[currentQuestionIndex]);
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText(options[currentQuestionIndex][i]);
            optionButtons[i].setEnabled(true);
            optionButtons[i].setStrokeColorResource(android.R.color.transparent);
        }
        nextButton.setVisibility(View.GONE);
    }

    private void checkAnswer(int selectedIndex) {
        boolean isCorrect = (selectedIndex == correctAnswers[currentQuestionIndex]);
        
        for (MaterialButton btn : optionButtons) {
            btn.setEnabled(false);
        }

        if (isCorrect) {
            Toast.makeText(this, "Correct! ✨", Toast.LENGTH_SHORT).show();
            optionButtons[selectedIndex].setStrokeColorResource(android.R.color.holo_green_light);
            optionButtons[selectedIndex].setStrokeWidth(4);
        } else {
            Toast.makeText(this, "Wrong answer ❌", Toast.LENGTH_SHORT).show();
            optionButtons[selectedIndex].setStrokeColorResource(android.R.color.holo_red_light);
            optionButtons[selectedIndex].setStrokeWidth(4);
            // Show correct answer too
            optionButtons[correctAnswers[currentQuestionIndex]].setStrokeColorResource(android.R.color.holo_green_light);
            optionButtons[correctAnswers[currentQuestionIndex]].setStrokeWidth(4);
        }
        
        nextButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, currentQuestionIndex);
    }
}