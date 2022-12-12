package fi.nikitanoss.hytejengi_project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ExerciseActivity extends AppCompatActivity {

    private Button  readyBtn;
    private ImageButton menuBtn;

    private int random = new Random().nextInt(12); // randomizer initialization

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        // initializing TextViews
        TextView nameTV = findViewById(R.id.nameTV);
        TextView repsTV = findViewById(R.id.repsTV);
        TextView infoTV = findViewById(R.id.infoTV);

        // getting data from singleton array(randomized)
        String name = ExerciseSingleton.getInstance().getExercise(random).getName();
        String reps = ExerciseSingleton.getInstance().getExercise(random).getReps();
        String info = ExerciseSingleton.getInstance().getExercise(random).getInstructions();

        // setting exercises to show on screen
        nameTV.setText(name);
        repsTV.setText(reps);
        infoTV.setText(info);

        // Get back to main after exercise
        Intent mainIntent = new Intent(this, MainActivity.class);
        readyBtn = findViewById(R.id.rdyBtn);
        readyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainIntent);
            }
        });

        menuBtn = (ImageButton) findViewById(R.id.menuBtn);
        Intent menuIntent = new Intent(ExerciseActivity.this, SettingsActivity.class);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(menuIntent);
            }
        });


    }}