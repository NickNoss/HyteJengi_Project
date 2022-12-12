package fi.nikitanoss.hytejengi_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private ImageButton menuBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        ListView listView = findViewById(R.id.settingListView);

        List<String> settingsList = new ArrayList<>();
        settingsList.add("My Profile");
        settingsList.add("Main");
        settingsList.add("Exercises");
        settingsList.add("Logout");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, settingsList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                } else if(position==1){
                    Intent openMainActivity = new Intent(SettingsActivity.this, MainActivity.class);
                    openMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivityIfNeeded(openMainActivity, 0);
                } else if(position==2){
                    startActivity(new Intent(SettingsActivity.this, ExerciseActivity.class));

                } else {
                    startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
                }
            }
        });

        menuBtn = (ImageButton) findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
