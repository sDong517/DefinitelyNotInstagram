package com.example.definitelynotinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null){
            goMainActivity();
        }


        //Initialize with boilerplate code
        //TODO LEARN HOW TO NOT USE BOILERPLATE CODE
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        //On button click for login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "OnClick for Login Works!");

                //Store the user inputed username and passwords into strings
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                //Call the actual login function
                loginUser(username, password);
            }
        });
    }


    //Login Function
    private void loginUser(String username, String password) {
        Log.i(TAG, "Activated Login Function!");

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Login Issue", e);
                    Toast.makeText(LoginActivity.this,"Issue with Login!", Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(LoginActivity.this,"Success!", Toast.LENGTH_SHORT).show();
            }
        });

        };

    private void goMainActivity() {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}