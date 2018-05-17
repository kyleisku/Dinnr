package com.csulb.cecsymemeteam.dinnr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class NewAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        final RadioButton female = (RadioButton) findViewById(R.id.newAccount_femaleBtn);
        final RadioButton male = (RadioButton) findViewById(R.id.newAccount_maleBtn);
        final RadioButton notAns = (RadioButton) findViewById(R.id.newAccount_noAnsBtn);
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    male.setChecked(false);
                }
                if(notAns.isChecked()){
                    notAns.setChecked(false);
                }
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(female.isChecked()){
                    female.setChecked(false);
                }
                if(notAns.isChecked()){
                    notAns.setChecked(false);
                }
            }
        });
        notAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked()){
                    male.setChecked(false);
                }
                if(female.isChecked()){
                    female.setChecked(false);
                }
            }
        });
    }

    public void goBack(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void createAccount(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}
