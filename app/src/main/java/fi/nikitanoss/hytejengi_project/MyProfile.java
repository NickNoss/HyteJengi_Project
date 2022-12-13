package fi.nikitanoss.hytejengi_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

/**
 * Application profile page activity.
 *
 * @author Esa Koskinen
 * @author Nikita Nossenko
 * @author Elmo Erla
 * @version 1.0.0 12/2022
 */
public class MyProfile extends AppCompatActivity {
    //declaring variables
    private EditText height, weight;
    private TextView resulttext, myProfile;
    private String calculation, BMIresult;
    private Button calculate;
    private ImageButton menuBtn;
    private ArrayList<Double> bmiArray = new ArrayList<Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        //finding values for variables from xml
        weight = findViewById(R.id.editWeight);
        height = findViewById(R.id.editHeight);
        resulttext = findViewById(R.id.resultText);
        calculate = findViewById(R.id.bmiButton);
        myProfile = findViewById(R.id.settingsTitle);

        //setting up shared prefences
        SharedPreferences preferences = getSharedPreferences("Userinfo", 0);
        myProfile.setText("Hello " + preferences.getString("username", "") + "!");

        /**
         * Sets onClick function for calculate button to calculate BMI, print it on the screen and setup GraphView.
         */
        calculate.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param view Creates text on screen.
             */
            @Override
            public void onClick(View view) {
                String S1 = weight.getText().toString();
                String S2 = height.getText().toString();

                double weightValue = Double.parseDouble(S1);
                double heightValue = Double.parseDouble(S2) * 0.01;

                double BMI = weightValue / (heightValue * heightValue);
                bmiArray.add(BMI);
                GraphView graph = (GraphView) findViewById(R.id.bmiGV);

                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                double y;
                for (int x = 0; x < bmiArray.size(); x++) {
                    y = bmiArray.get(x);
                    series.appendData(new DataPoint(x, y), true, bmiArray.size());
                }
                graph.addSeries(series);

                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(bmiArray.size());

                graph.getViewport().setScrollable(true);
                graph.getViewport().setScalable(true);



                if (BMI < 16) {
                    BMIresult = "Severe Thinness";
                } else if (BMI < 18.5) {
                    BMIresult = "Moderate Thinness";
                } else if (BMI >= 18.5 && BMI <= 24.99) {
                    BMIresult = "Normal Weight";
                } else if (BMI >= 25 && BMI <= 29.99) {
                    BMIresult = "Overweight";
                } else {
                    BMIresult = "Obese";
                }

                calculation = "Result: \n\n" + String.format("%.2f", BMI) + "\n\n" + BMIresult;

                resulttext.setText(calculation);
            }
        });

        //declaring and setting up menu navigation button
        menuBtn = (ImageButton) findViewById(R.id.menuBtn);
        //Making new intent for user to move to SettingsActivity from MyProfile
        Intent menuIntent = new Intent(MyProfile.this, NavigationActivity.class);
        //Moving to said intent with button press
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(menuIntent);
            }
        });
    }
}