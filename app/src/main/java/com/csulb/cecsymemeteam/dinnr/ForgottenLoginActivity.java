package com.csulb.cecsymemeteam.dinnr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ForgottenLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_login);
        TextView Sent = findViewById(R.id.forgottenLogin_emailSent);
    }

    public void goBack(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void sendEmail(View v){
        EditText text = findViewById(R.id.forgottenLogin_userTxtField);
        if(((EditText)findViewById(R.id.forgottenLogin_userTxtField)).getText().length() == 0 && ((EditText)findViewById(R.id.forgottenLogin_passwordTxtField)).getText().length() == 0){
            ((TextView)findViewById(R.id.forgottenLogin_emailSent)).setText("You need to enter something to retrieve your information");
        }
        else{
            ((TextView)findViewById(R.id.forgottenLogin_emailSent)).setText("Email successfully sent!");
        }
    }
}
