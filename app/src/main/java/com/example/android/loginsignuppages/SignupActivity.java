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

public class SignupActivity extends AppCompatActivity {


    TextView loginTextView, signupTextView;
    Button signupBtn;
    EditText email, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginTextView = findViewById(R.id.loginText);
        signupTextView = findViewById(R.id.signupText);
        signupBtn = findViewById(R.id.signupBtn);
        email = findViewById(R.id.emailEditText);
        pwd = findViewById(R.id.pwdEditText);

        loginTextView.setPaintFlags(loginTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        signupTextView.setEnabled(false);
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginTextView.setEnabled(false);
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
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
                    signupBtn.setEnabled(false);
            }
        });

    }
}
