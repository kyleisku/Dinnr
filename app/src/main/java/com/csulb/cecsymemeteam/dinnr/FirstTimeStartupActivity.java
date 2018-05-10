package com.csulb.cecsymemeteam.dinnr;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class FirstTimeStartupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_startup);

        TextView termsOfService = findViewById(R.id.firstTimeStartUp_termsOfServiceTxt);
        termsOfService.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void startTour(View v){
        startActivity(new Intent(this, videoActivity.class));
    }
}
