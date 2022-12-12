package fi.nikitanoss.hytejengi_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    private EditText usernameTextField, passwordTextField;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usernameTextField = findViewById(R.id.usernameEditText);
        this.passwordTextField = findViewById(R.id.passwordEditText);
        this.loginButton = findViewById(R.id.loginButton);
        Intent MainIntent = new Intent(this, MainActivity.class);
        String username = usernameTextField.getText().toString();
        String password = passwordTextField.getText().toString();

        SharedPreferences sp=getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor Editor=sp.edit();
        SharedPreferences shared=this.getSharedPreferences("Login", MODE_PRIVATE);


        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String unm = shared.getString("User", username);
                String pass = shared.getString("PassW", password);
                if(unm.isEmpty()&&pass.isEmpty()) {
                    Editor.putString("User",username);
                    Editor.putString("PassW",password);
                    Editor.commit();
                    startActivity(MainIntent);
                    Toast.makeText(LoginActivity.this, "L SUCCESSFUL", Toast.LENGTH_SHORT).show();
                } else if (unm.equals(usernameTextField.getText().toString())&& pass.equals(passwordTextField.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    startActivity(MainIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}