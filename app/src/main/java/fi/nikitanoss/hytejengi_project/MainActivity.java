package fi.nikitanoss.hytejengi_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);

    TextView timerText;
    Button startButton;

    Timer timer;
    TimerTask timerTask;
    Double time = 0.0;

    boolean timerStarted = false;

    private int CurrentProgress = 0;
    private ProgressBar progressBar;

    //variables for stepcounter
    private TextView textView;
    private double MagnitudePrev = 0;
    private Integer stepCount = 0;
    //end


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.activityProgressBar);

        timerText = (TextView) findViewById(R.id.timerTextView);
        startButton = (Button) findViewById(R.id.startBtn);

        timer = new Timer();

        Intent exerciseIntent = new Intent(this, ExerciseActivity.class);

        if (hour == 22) {
            CurrentProgress = 0;
            stepCount = 0;
        }


        startButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                    startActivity(exerciseIntent);
                    CurrentProgress += 25;
                    progressBar.setProgress(CurrentProgress);
                    progressBar.setMax(100);
                    stopTimer();
                }

        });
        //STEPCOUNTER
        textView = findViewById(R.id.steps);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener stepDetector = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent!= null){
                    float x_suunta = sensorEvent.values[0];
                    float y_suunta = sensorEvent.values[1];
                    float z_suunta = sensorEvent.values[2];

                    double Magnitude = Math.sqrt(x_suunta*x_suunta + y_suunta*y_suunta + z_suunta*z_suunta);
                    double MD = Magnitude - MagnitudePrev;
                    MagnitudePrev = Magnitude;

                    if (MD > 3){
                        stepCount++;
                    }
                    textView.setText(stepCount.toString());
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        sensorManager.registerListener(stepDetector, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        //end
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

    private void stopTimer() {
        timerStarted = false;
        timerTask.cancel();
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


    //Methods for stepcounter
    protected void onPause() {
        super.onPause();
        stopTimer();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt("stepCount", stepCount);
        editor.apply();
        editor.putInt("CurrentProgress", CurrentProgress);
        editor.apply();
        if (hour == 22) {
            CurrentProgress = 0;
            stepCount = 0;
        }
    }

    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt("stepCount", stepCount);
        editor.apply();
        editor.putInt("CurrentProgress", CurrentProgress);
        editor.apply();
        if (hour == 22) {
            CurrentProgress = 0;
            stepCount = 0;
        }
    }

    protected void onResume() {
        super.onResume();
        startTimer();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        stepCount = sharedPreferences.getInt("stepCount", 0);
        CurrentProgress = sharedPreferences.getInt("CurrentProgress", CurrentProgress);
        progressBar.setProgress(sharedPreferences.getInt("CurrentProgress", 0));
        if (hour == 22) {
            CurrentProgress = 0;
            stepCount = 0;
        }
    }
    //ends
}