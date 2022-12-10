package fi.nikitanoss.hytejengi_project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;


public class ExerciseActivity extends AppCompatActivity {
    private TextView exerName;
    private Button kokeiluButton;
    private static final String TAG = "ExerciseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        exerName = findViewById(R.id.exerciseName);

        /*
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
                            Log.e(TAG, "onResponse: All names " + data1.getName());
                            exerName.setText(data1.getName());
                        }
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });
         */

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.api-ninjas.com/v1/exercises?muscle=biceps")
                .get()
                .addHeader("X-Api-Key", "PNaMlfXN+zoH+59tQrauWw==TY47R7TCS4r7Wmrr")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    Log.e(TAG, "onResponse: " + myResponse);

                    /*
                    ArrayList<Model.data> data1 = modelResult.getData();

                    for (Model.data data : data1) {
                        Log.e(TAG, "onResponse: " + data.getName());
                    }
                     */

                    ExerciseActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            exerName.setText(myResponse);
                        }
                    });
                }
            }
        });
    }
}
