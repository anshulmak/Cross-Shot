package com.crossshot.CrossShot1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class splashscreen extends AppCompatActivity {
Button close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        close = (Button) findViewById(R.id.close);
        VideoView videoView = (VideoView)findViewById(R.id.videoView4);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.myvideo2);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (splashscreen.this, Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
