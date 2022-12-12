package fi.nikitanoss.hytejengi_project;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    public static final String EXTRA_NAME = "Name";
    private ArrayAdapter<Settings> listAdapter;


    /*ListView listView = findViewById(R.id.settingsLV);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Handle menu item clicks here
            switch (position) {
                case 0:
                    // Open User settings screen
                    break;
                case 1:
                    // Open My activity screen
                    break;
                case 2:
                    // Open About screen
                    break;
            }
        }
    }; */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final ListView lv = findViewById(R.id.settingsLV);
        this.listAdapter = new ArrayAdapter<Settings>(
                this,
                android.R.layout.simple_list_item_1,
                GlobalSettings.getInstance().getSettings()
        );
        lv.setAdapter(this.listAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick(" + i + ")");
                String name = GlobalSettings.getInstance().getSetting(i).toString();
               // startActivity(getActivity(i));
            }
        });
    }
}
