package com.csulb.cecsymemeteam.dinnr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private TextView warningText;
    EditText userTxtField;
    EditText passTxtField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         warningText = findViewById(R.id.login_warningTxt);
         userTxtField = findViewById(R.id.login_userTxtField);
         passTxtField = findViewById(R.id.login_passwordTxtField);

    }

    public void goBack(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void login(View v){
        if(userTxtField.getText().length() < 1 || passTxtField.getText().length() < 1){
            warningText.setText("Neither the username nor password should be blank");
        }
        else{
            DataStorage.setLoggedIn(true);
            warningText.setText("");
            DataStorage.setLoginName(userTxtField.getText() + "");
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void createAccount(View v){
        startActivity(new Intent(this, NewAccountActivity.class));
    }

    public void gotoForgottenLogin(View v){
        startActivity(new Intent(this, ForgottenLoginActivity.class));
    }
}
