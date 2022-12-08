package fi.nikitanoss.hytejengi_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExerciseActivity extends AppCompatActivity {
    private TextView exerName;
    private Button kokeiluButton;
    private static final String TAG = "ExerciseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        exerName = findViewById(R.id.exerciseName);
        kokeiluButton = findViewById(R.id.buttonKokeilu);


        kokeiluButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Methods methods = RetroFitClient.getRetrofitInstance().create(Methods.class);
                Call<Model> call = methods.getAllData();

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.e(TAG, "onResponse: code " + response.code());

                        ArrayList<Model.data> data = response.body().getData();
                        
                        for (Model.data data1 : data) {
                            Log.e(TAG, "onResponse: All names" + data1.getEmail());
                            exerName.setText(data1.getEmail());
                        }
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });
    }
}
