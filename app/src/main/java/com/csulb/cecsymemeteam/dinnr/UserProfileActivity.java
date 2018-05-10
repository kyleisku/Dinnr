package com.csulb.cecsymemeteam.dinnr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        TextView temp = findViewById(R.id.userprofile_username);
        temp.setText(DataStorage.getLoginName());
        temp = findViewById(R.id.userprofile_name);
        temp.setText("Adam");
        temp = findViewById(R.id.userprofile_lastName);
        temp.setText("Levine");
        temp = findViewById(R.id.userprofile_gender);
        temp.setText("Male/Female");

        Button btn = findViewById(R.id.userProfile_backBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(findViewById(R.id.userProfile_backBtn).getContext(), MainActivity.class));
            }
        });

        btn = findViewById(R.id.userprofile_logoutBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataStorage.setLoginName("");
                DataStorage.setLoggedIn(false);
                startActivity(new Intent(findViewById(R.id.userProfile_backBtn).getContext(), MainActivity.class));
            }
        });
    }
}
