package fi.nikitanoss.hytejengi_project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ExerciseActivity extends AppCompatActivity {

    private Button getBtn, readyBtn;
    private TextView result;
    private OkHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        // Get back to main after exercise
        Intent mainIntent = new Intent(this, MainActivity.class);
        readyBtn = findViewById(R.id.rdyBtn);
        readyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainIntent);
                super.startTimer();
            }
        });


        result = (TextView) findViewById(R.id.exerciseName);
        getBtn = (Button) findViewById(R.id.kokeiluButton);
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWebservice();
            }
        });
        client = new OkHttpClient();

    }

    private void getWebservice() {
        final Request request = new Request.Builder().url("https://api.api-ninjas.com/v1/exercises?muscle=biceps")
                .get()
                .addHeader("X-Api-Key", "PNaMlfXN+zoH+59tQrauWw==TY47R7TCS4r7Wmrr")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText("Failure !");
                    }
                });
            }
            @Override
            public void onResponse(Call call, final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String json = response.body().string();
                            result.setText(json);

                        } catch (IOException ioe) {
                            result.setText("Error during get body");
                        }
                    }
                });
            }
        });
    }
}


/*public class ExerciseActivity extends AppCompatActivity {
    private TextView exerName;
    private Button kokeiluButton;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        exerName = findViewById(R.id.exerciseName);
        kokeiluButton = findViewById(R.id.kokeiluButton);


        kokeiluButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Methods methods = RetroFitClient.getRetrofitInstance().create(Methods.class);
                Call<Model> call = methods.getAllData();

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {


                        ArrayList<Model.data> data = response.body().getData();

                        for (Model.data data1 : data) {

                            exerName.setText(data1.getName());
                        }
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });
            }
        });


        //client = new OkHttpClient();

    }*/

    /*private void getWebService() {
        final Request request = new Request.Builder()
                .url("https://api.api-ninjas.com/v1/exercises?muscle=biceps")
                .get()
                .addHeader("X-Api-Key", "PNaMlfXN+zoH+59tQrauWw==TY47R7TCS4r7Wmrr")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        exerName.setText("Failure!");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String json = response.body().toString();
                            Gson gson = new Gson();
                            Model[] models = gson.fromJson(json, Model[].class);
                            exerName.setText(models.toString());
                        } catch (IOException ioe) {
                            exerName.setText("Error during get body");
                        }
                    }
                });
            }
        });
    }
}*/