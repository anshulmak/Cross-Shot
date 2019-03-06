package com.crossshot.CrossShot1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.Map;
import com.inmobi.ads.*;
import com.inmobi.sdk.*;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class name extends AppCompatActivity {

    Button st;
    TextView play2,play1;
    private AdView mAdView1;
    EditText n1,n2;
    RadioButton rb;
    String pl1,pl2,text,str;
    boolean computer,round3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        InMobiSdk.init(this, "8e0318cc86f44519befd79fc1503136a"); //'this' is used specify context
        InMobiBanner banner = (InMobiBanner)findViewById(R.id.banner);
        banner.load();

        Intent intent = getIntent();
        computer = intent.getExtras().getBoolean("comp");

        st = (Button) findViewById(R.id.st);
        rb = (RadioButton) findViewById(R.id.rb);
        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);
        play1 = (TextView) findViewById(R.id.play1);
        play2 = (TextView) findViewById(R.id.play2);
        round3=false;


        str = n1.getText().toString();
        text = n2.getText().toString();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        n1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    n1.setText("");
                }
            }
        });
        n2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    n2.setText("");

                }
            }
        });
        if(computer)
        {
            n2.setText("Computer");
            n2.setVisibility(View.INVISIBLE);
            play2.setVisibility(View.INVISIBLE);
            rb.setVisibility(View.INVISIBLE);
            play1.setText("Player Name :");
        }
        if(!computer)
        {
            n2.setVisibility(View.VISIBLE);
            play2.setVisibility(View.VISIBLE);
            rb.setVisibility(View.VISIBLE);
            play1.setText("PLAYER 1");

        }
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                round3=true;
                rb.setChecked(true);
            }
        });

        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = n1.getText().toString();
                text = n2.getText().toString();
                if (str.equals("")){
                    n1.setText(R.string.player1wins);
                }
                if (text.equals("") && !computer)
                {
                    n2.setText(R.string.player2wins);
                }
                Intent i = new Intent (name.this, MainActivity.class);
                pl1 = n1.getText().toString();
                pl2 = n2.getText().toString();
                i.putExtra("name1",pl1);
                i.putExtra("name2",pl2);
                i.putExtra("comp1",computer);
                i.putExtra("3round",round3);
                startActivity(i);
                overridePendingTransition( R.anim.left_to_right,R.anim.right_to_left);
            }
        });
    }
    public void onBackPressed () {
        Intent i = new Intent (name.this, Main2Activity.class);
        startActivity(i);
        overridePendingTransition( R.anim.left_to_right,R.anim.right_to_left);
    }
   @Override
    protected void onResume() {
        super.onResume();
        mAdView1.resume();
    }
}
