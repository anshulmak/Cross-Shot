package com.crossshot.CrossShot1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Map;
import com.inmobi.ads.*;
import com.inmobi.sdk.*;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class instructions extends AppCompatActivity {
    Button start;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        start = (Button) findViewById(R.id.start);


        InMobiSdk.init(this, "8e0318cc86f44519befd79fc1503136a"); //'this' is used specify context
        InMobiBanner banner = (InMobiBanner)findViewById(R.id.banner);
        banner.load();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (instructions.this, tutorial1.class);
                startActivity(i);
                overridePendingTransition( R.anim.left_to_right,R.anim.right_to_left);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        mAdView.resume();
    }
    public void onBackPressed () {
        Intent i = new Intent (instructions.this, Main2Activity.class);
        startActivity(i);
        overridePendingTransition( R.anim.left_to_right,R.anim.right_to_left);
    }

}
