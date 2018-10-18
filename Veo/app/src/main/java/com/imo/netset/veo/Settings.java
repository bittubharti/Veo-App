package com.imo.netset.veo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by netset on 4/7/16.
 */
public class Settings extends Activity implements View.OnClickListener {
    TranslateAnimation slide;
    RelativeLayout r6;
    ImageView im;
     Button prefe,help;
    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        r6= (RelativeLayout)findViewById(R.id.relative_layout6);
        im=(ImageView)findViewById(R.id.im);
        im.setOnClickListener(this);
        slide = new TranslateAnimation(800, 0, 0,0 );
        slide.setDuration(600);
        slide.setFillAfter(true);
        r6.startAnimation(slide);

        prefe=(Button)findViewById(R.id.preference_btn);
        prefe.setOnClickListener(this);
        help=(Button)findViewById(R.id.help_btn);
        help.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
              case R.id.im:
                   Log.e("Value check",GeneralValues.get_checkvalue(Settings.this));

                   if (GeneralValues.get_checkvalue(Settings.this).equalsIgnoreCase("1")) {
                    Intent intent_pre =new Intent (Settings.this,MainActivity.class);
                    startActivity(intent_pre);
                    finish();
                    }
                   else {

                            Intent intent=new Intent(Settings.this,Search_People.class);
                             startActivity(intent);
                              overridePendingTransition(R.anim.slide3, R.anim.slide4);
                              finish();
                   }

                  break;

                case R.id.preference_btn:

                        Intent intent_pre =new Intent (Settings.this,Preferences.class);
                        startActivity(intent_pre);
                break;

            case R.id.help_btn:

                   Intent intent_email=new Intent(Settings.this,Email.class);
                   startActivity(intent_email);
             break;
        }
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();

        if (GeneralValues.get_checkvalue(Settings.this).equalsIgnoreCase("1"))
        {
            Intent intent_pre =new Intent (Settings.this,MainActivity.class);
            startActivity(intent_pre);
        }
           else
           {

               Intent intent_pre =new Intent (Settings.this,Preferences.class);
               startActivity(intent_pre);
           }


    }
}
