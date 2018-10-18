package com.imo.netset.veo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by netset on 23/6/16.
 */
public class Splash_Activity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Thread timerThread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }

                finally
                {
                    Intent intent = new Intent(Splash_Activity.this,Gender_Selection.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
         protected void onPause()
    {

        super.onPause();
        finish();
    }





}
