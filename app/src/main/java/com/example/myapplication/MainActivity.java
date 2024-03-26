package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;
import android.content.Intent;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password_toggle); // Password field
        EditText rePassword = findViewById(R.id.repassword); // Re-enter password field

        MaterialButton regbtn = findViewById(R.id.signupbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameStr = username.getText().toString();
                String passwordStr = password.getText().toString();
                String rePasswordStr = rePassword.getText().toString();

                if (TextUtils.isEmpty(usernameStr) || TextUtils.isEmpty(passwordStr) || TextUtils.isEmpty(rePasswordStr)) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!passwordStr.equals(rePasswordStr)) {
                    Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity.this, "Registration Successful for " + usernameStr, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
