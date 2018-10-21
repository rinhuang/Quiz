package com.example.shuqi.infs3634quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// enable toasts
import android.view.View;
import android.widget.Toast;
import android.content.Context;
import android.app.Activity;
// enable textview
import android.widget.TextView;
// enable buttons
import android.widget.Button;
// enable random numbers
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private TextView questionTxt;
    private Button trueBtn;
    private Button falseBtn;
    public String questions[] = new String[10];
    public int answers[] = new int[10];
    public int index = 0;
    public int correct = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // get the thing ready
        questionTxt = (TextView) findViewById(R.id.questionTxt);
        // populate the questions
        questions[0] = "The Android 8.1 version name is Oreo.";
        questions[1] = "Android SDK mainly uses Java.";
        questions[2] = "Kotlin code is code you can use for Android SDK.";
        questions[3] = "Android SDK can also be used with Xcode.";
        questions[4] = "You can program with Linux, Windows, and Mac for Android.";
        questions[5] = "Programming on Android is fun.";
        questions[6] = "A toast is the clinking of a wine glass.";
        questions[7] = "Androids run Windows Phone OS.";
        questions[8] = "Android is a closed-source proprietary operating system.";
        questions[9] = "Android phones usually run on ARM, not x86_64.";
        answers[0] = 1;
        answers[1] = 1;
        answers[2] = 1;
        answers[3] = 0;
        answers[4] = 1;
        answers[5] = 0;
        answers[6] = 0;
        answers[7] = 0;
        answers[8] = 0;
        answers[9] = 1;
        // initialise
        trueBtn = (Button) findViewById(R.id.trueBtn);
        falseBtn = (Button) findViewById(R.id.falseBtn);
        questionTxt.setText(questions[index]);
        View.OnClickListener trueListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (answers[index] == 1){
                    Context context = getApplicationContext();
                    correct++;
                    CharSequence text = "Correct! Score: " + correct + "/10";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else{
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect! Score: " + correct + "/10";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                index++;
                questionTxt.setText(questions[index]);
                if (index == 9){
                    Context context = getApplicationContext();
                    CharSequence text = "Final Score: " + correct + "/10";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    index = 0;
                    correct = 0;
                }
            }
        };
        trueBtn.setOnClickListener(trueListener);
        View.OnClickListener falseListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (answers[index] == 0){
                    correct++;
                    Context context = getApplicationContext();
                    CharSequence text = "Correct! Score: " + correct + "/10";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else{
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect! Score: " + correct + "/10";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                index++;
                questionTxt.setText(questions[index]);
                if (index == 9){
                    Context context = getApplicationContext();
                    CharSequence text = "Final Score: " + correct + "/10";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    index = 0;
                    correct = 0;
                }
            }
        };
        falseBtn.setOnClickListener(falseListener);
    }
}
