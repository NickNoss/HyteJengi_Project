package fi.nikitanoss.hytejengi_project;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public final static String EXTRA_USERNAME = "com.example.test.USERNAME";
    public final static String EXTRA_PASSWORD = "com.example.test.PASWORD";
    private EditText usernameTextField, passwordTextField;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usernameTextField = findViewById(R.id.usernameEditText);
        this.passwordTextField = findViewById(R.id.passwordEditText);
        this.loginButton = findViewById(R.id.loginButton);
        Intent intent = new Intent(this, MainActivity.class);
        String username = usernameTextField.getText().toString();
        String password = passwordTextField.getText().toString();
        intent.putExtra(EXTRA_USERNAME, username);
        intent.putExtra(EXTRA_PASSWORD, password);

        //admin & admin

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(usernameTextField.getText().toString().equals("admin") && passwordTextField.getText().toString().equals("admin")) {
                    //correct
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                } else {
                    //incorrect
                    Toast.makeText(LoginActivity.this, "LOGIN FAILED!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    /*public void loginButtonPressed(View v){
        Intent intent = new Intent(this, MainActivity.class);
        String username = usernameTextField.getText().toString();
        String password = passwordTextField.getText().toString();
        intent.putExtra(EXTRA_USERNAME, username);
        intent.putExtra(EXTRA_PASSWORD, password);
        startActivity(intent);

    }*/
}