package fi.nikitanoss.hytejengi_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {
    EditText height, weight;
    TextView resulttext;
    String calculation, BMIresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        weight = findViewById(R.id.editWeight);
        height = findViewById(R.id.editHeight);
        resulttext = findViewById(R.id.resultText);
    }

    public void calculateBMI(View v) {
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();

        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2);

        float BMI = weightValue / (heightValue * heightValue);

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
}