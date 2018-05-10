package com.csulb.cecsymemeteam.dinnr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);
        final VideoView video = findViewById(R.id.video_videoView);
        String videoPath = "android.resource://com.csulb.cecsymemeteam.dinnr/" + R.raw.tutorial;
        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);
        MediaController mediaC = new MediaController(this);
        video.setMediaController(mediaC);
        mediaC.setAnchorView(video);
        video.start();
        DataStorage.setTutorialPlayed(true);
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                startActivity(new Intent(findViewById(R.id.video_videoView).getContext(), MainActivity.class));
            }
        });
    }
}
