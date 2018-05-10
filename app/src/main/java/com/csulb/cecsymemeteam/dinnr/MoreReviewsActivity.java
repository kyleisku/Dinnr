package com.csulb.cecsymemeteam.dinnr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MoreReviewsActivity extends AppCompatActivity {
    private int numOfReviews = 0;
    private ArrayList<Review> reviews = new ArrayList<Review>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_reviews);

        LinearLayout scrollView = findViewById(R.id.moreReviews_reviewsList);

        //Grabs 10 reviews (from a database or whatever) and creates it on screen so that the user can view them
        for(int i = 0; i < 10; i++){
            reviews.add(new Review());
            scrollView.addView(ReviewFactory.generateReview(this, reviews.get(i), numOfReviews), new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            numOfReviews++;
        }
    }

    /**
     * directs users back to the restaurant profile activity
     * @param v
     */
    public void goBack(View v){
        startActivity(new Intent(this, ProfileActivity.class));
    }

    /**
     * directs users over to the write review activity
     * @param v
     */
    public void writeReview(View v){
        startActivity(new Intent(this, WriteReviewActivity.class));
    }
}
