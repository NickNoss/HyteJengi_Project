package fi.nikitanoss.hytejengi_project;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    public static final String EXTRA_NAME = "Name";
    private ArrayAdapter<Settings> listAdapter;

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

        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick(" + i + ")");
                String name = GlobalSettings.getInstance().getSetting(i).toString();
                startActivity(getActivity(i));
            }
        });*/
    }
}
