package com.crossshot.CrossShot1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class check extends AppCompatActivity {
    Boolean firstTime ;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("ShaPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
       firstTime=sharedPreferences.getBoolean("first", true);
        if(firstTime)//if running for first time
        //Splash will load for first time
        {
            editor.putBoolean("first",false);
            //For commit the changes, Use either editor.commit(); or  editor.apply();.
            editor.commit(); editor.apply();
            Intent j=new Intent(check.this,splashscreen.class);
            startActivity(j);
        }
        else
        {
            Intent a=new Intent(check.this,Main2Activity.class);
            startActivity(a);
            finish();
        }
    }

}

