package fi.nikitanoss.hytejengi_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView timerText;
    Button startButton;

    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;

    boolean timerStarted = false;

    private int CurrentProgress = 0;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.activityProgressBar);

        timerText = (TextView) findViewById(R.id.timerTextView);
        startButton = (Button) findViewById(R.id.startBtn);

        timer = new Timer();

        startButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(timerStarted == false) {
                    timerStarted = true;
                    startTimer();
                    CurrentProgress = CurrentProgress + 25;
                    progressBar.setProgress(CurrentProgress);
                    progressBar.setMax(100);
                }
            }
        });
    }

    private void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerText.setText(getTimerText());
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private String getTimerText() {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;
        int hours = ((rounded % 86400) / 3600);

        return formatTime(seconds, minutes, hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return String.format("%02d",hours) + " : " + String.format("%02d",minutes) + " : " + String.format("%02d",seconds);
    }

    public void exerciseButtonPressed(View v) {
        Intent intent = new Intent(this, ExerciseActivity.class);
        startActivity(intent);

    }
}