package com.example.android.loginsignuppages;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView loginTextView, signupTextView, forgotPasswordText;
    Button loginbtn;
    EditText email, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginTextView = findViewById(R.id.loginText);
        signupTextView = findViewById(R.id.signupText);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);
        loginbtn = findViewById(R.id.loginbtn);
        email = findViewById(R.id.emailEditText);
        pwd = findViewById(R.id.pwdEditText);


        signupTextView.setPaintFlags(signupTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        forgotPasswordText.setPaintFlags(forgotPasswordText.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        loginTextView.setEnabled(false);

        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupTextView.setEnabled(false);
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = email.getText().toString();
                String y = pwd.getText().toString();

                if (TextUtils.isEmpty(x)) {
                    email.setError("Please enter your email id correctly");
                }
                if (TextUtils.isEmpty(y)) {
                    pwd.setError("Please enter your password correctly");
                } else
                    loginbtn.setEnabled(false);
            }
        });


    }

}
