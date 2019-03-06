package com.crossshot.CrossShot1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class tutorial1 extends AppCompatActivity {
Button prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial1);
        prev = (Button) findViewById(R.id.prev);
        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.myvideo2);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (tutorial1.this, instructions.class);
                startActivity(i);
            }
        });
    }
    public void onBackPressed () {
        super.onBackPressed();
        overridePendingTransition( R.anim.left_to_right,R.anim.right_to_left);

    }
}
