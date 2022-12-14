package fi.nikitanoss.hytejengi_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Application login activity.
 *
 * @author Jere Paajaste
 * @author Esa Koskinen
 * @version 1.0.0 12/2022
 */
public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login, register;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        login = findViewById(R.id.loginButton);
        register = findViewById(R.id.register);


        preferences = getSharedPreferences("Userinfo", 0);

        /**
         * Making new eventListener and checking if user already exist, if it exists it lets user to login
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                String registeredUsername = preferences.getString("username", "");
                String registeredPassword = preferences.getString("password", "");

                if (usernameValue.equals(registeredUsername) && passwordValue.equals(registeredPassword)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(LoginActivity.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Starting next activity on button press.
         */
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}