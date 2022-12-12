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

public class MyProfile extends AppCompatActivity {
    EditText height, weight;
    TextView resulttext, myProfile;
    String calculation, BMIresult;
    Button calculate;
    ImageButton menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        weight = findViewById(R.id.editWeight);
        height = findViewById(R.id.editHeight);
        resulttext = findViewById(R.id.resultText);
        calculate = findViewById(R.id.bmiButton);
        myProfile = findViewById(R.id.settingsTitle);

        SharedPreferences preferences = getSharedPreferences("Userinfo", 0);
        myProfile.setText("Hello " + preferences.getString("username", "") + "!");

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String S1 = weight.getText().toString();
                String S2 = height.getText().toString();

                double weightValue = Double.parseDouble(S1);
                double heightValue = Double.parseDouble(S2) * 0.01;

                double BMI = weightValue / (heightValue * heightValue);

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

                calculation = "Result: \n\n" + BMI + "\n" + BMIresult;

                resulttext.setText(calculation);
            }
        });

        menuBtn = (ImageButton) findViewById(R.id.menuBtn);
        Intent menuIntent = new Intent(MyProfile.this, SettingsActivity.class);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(menuIntent);
            }
        });
    }

}