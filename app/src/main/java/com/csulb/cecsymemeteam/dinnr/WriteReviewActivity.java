package com.csulb.cecsymemeteam.dinnr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WriteReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);
        Button send = findViewById(R.id.writeReview_sendBtn);
        final EditText title = findViewById(R.id.writeReview_titleTxtField);
        final EditText comment = findViewById(R.id.writeReview_reviewTxtField);
        final EditText Rating = findViewById(R.id.writeReview_ratingTxtField);
        final TextView charactersLeft = findViewById(R.id.writeReview_maxCharactersTxt);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Rating.getText().length() > 0) {
                    Review r = new Review("Anonymous", "google.com", title.getText().toString(),
                            comment.getText().toString(), processStarRating(Rating.getText() + ""));
                    if (DataStorage.isLoggedIn()) {
                        r.setProfileName(DataStorage.getLoginName());
                    }
                    DataStorage.getRestaurant().addReview(r, 0);
                    sendReview(view);
                }
            }
        });

        charactersLeft.setText("Characters Left: 500");

        comment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                charactersLeft.setText(charactersLeft.getText().subSequence(0, 17) + "" + (500 - comment.getText().length()));
            }
        });
    }

    public static int processStarRating(String str){
        int starRating = Integer.parseInt(str);
        if(starRating > 5){
            return 5;
        }
        else if(starRating < 0){
            return 0;
        }
        else{
            return starRating;
        }
    }

    public void goBack(View v){
        startActivity(new Intent(this, ProfileActivity.class));
    }
    public void sendReview(View v)
    {
        startActivity(new Intent(this, ProfileActivity.class));
    }
}
