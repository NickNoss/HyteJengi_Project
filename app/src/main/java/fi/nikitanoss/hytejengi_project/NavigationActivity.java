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

/**
 * Application navigation activity.
 *
 * @author Esa Koskinen
 * @version 1.0.0 12/2022
 */

public class NavigationActivity extends AppCompatActivity {

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
                    startActivity(new Intent(NavigationActivity.this, MyProfile.class));
                } else if(position==1){
                    Intent openMainActivity = new Intent(NavigationActivity.this, MainActivity.class);
                    openMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivityIfNeeded(openMainActivity, 0);
                } else if(position==2){
                    startActivity(new Intent(NavigationActivity.this, ExerciseActivity.class));

                } else {
                    startActivity(new Intent(NavigationActivity.this, LoginActivity.class));
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
