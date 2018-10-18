package com.imo.netset.veo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.skyfishjy.library.RippleBackground;

/**
 * Created by netset on 24/6/16.
 */
public  class Search_People extends Activity
{
  private boolean timerHasStarted = false;
    private Button startB;
  private TextView text;
  private static final String tag = "Main";
   private MalibuCountDownTimer countDownTimer;
   private final long startTime = 3600000;
   private final long interval = 1000;
    TranslateAnimation slide;
     ImageView im1,im2,setting,chat;
    RelativeLayout r1,r2,r3,r4,r5,r6;

  Button button_delete,button_cancel,button_delete2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
         setContentView(R.layout.search_laout);
        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
         rippleBackground.startRippleAnimation();


        text = (TextView) this.findViewById(R.id.timer);
        countDownTimer = new MalibuCountDownTimer(startTime, interval);


       // rippleBackground.stopRippleAnimation();
        button_cancel=(Button)findViewById(R.id.buttonCancel);
        button_delete=(Button)findViewById(R.id.buttonDelete);
        r1 = (RelativeLayout)findViewById(R.id.relativeLaout1);
        r2=(RelativeLayout)findViewById(R.id.relativeLayout2);
        r3=(RelativeLayout)findViewById(R.id.relativeLayout3);
        r4=(RelativeLayout)findViewById(R.id.relative_up);
        r5=(RelativeLayout)findViewById(R.id.relative_bottom);


        im1 = (ImageView) findViewById(R.id.uparrow);
        im2=(ImageView)findViewById(R.id.downarrow);
        button_delete2=(Button)findViewById(R.id.Delete_bottom);
        setting=(ImageView)findViewById(R.id.setting1);
       chat=(ImageView)findViewById(R.id.chat_id);
        im1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                r2.setVisibility(View.VISIBLE);
                r3.setVisibility(View.VISIBLE);
                r4.setVisibility(View.VISIBLE);
                slide = new TranslateAnimation(0, 0, 400,0 );
                slide.setDuration(800);
                slide.setFillAfter(true);

                r2.startAnimation(slide);
                r3.startAnimation(slide);

                im1.setVisibility(View.GONE);

            }
        });

        im2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                slide = new TranslateAnimation(0, 0, 0,240 );
                slide.setDuration(800);
                slide.setFillAfter(false);
                r2.startAnimation(slide);
                r3.startAnimation(slide);
                slide.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        r2.setVisibility(View.GONE);
                        r3.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        im1.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });





        button_delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                  r5.setVisibility(View.VISIBLE);
                TranslateAnimation slide = new TranslateAnimation(400, 0, 0,0 );
                slide.setDuration(800);
                slide.setFillAfter(true);

                 r5.startAnimation(slide);
                im1.setVisibility(View.GONE);


            }
        });

        button_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                r2.setVisibility(View.VISIBLE);
                r3.setVisibility(View.VISIBLE);
                r4.setVisibility(View.VISIBLE);
                 slide = new TranslateAnimation(0, 800, 0,0 );
                slide.setDuration(900);
                slide.setFillAfter(true);
                r5.startAnimation(slide);
                r5.setVisibility(View.GONE);

                slide.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        r2.setVisibility(View.VISIBLE);
                        r3.setVisibility(View.VISIBLE);
                        r4.setVisibility(View.VISIBLE);
                    }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


            }
        });

        button_delete2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(Search_People.this,MainActivity.class);

                startActivity(intent1);


            }
        });

            if (!timerHasStarted)
              {
            countDownTimer.start();
            timerHasStarted = true;

               }
            else
              {

            countDownTimer.cancel();
            timerHasStarted = false;


               }

            setting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                GeneralValues.set_checkvalue(Search_People.this,"0");

                Intent intent3=new Intent(Search_People.this,Settings.class);
                startActivity(intent3);

                overridePendingTransition(R.anim.slide1, R.anim.slide2);



            }
        });



        chat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent_chat=new Intent(Search_People.this,ChatActivity.class);
                startActivity(intent_chat);





            }
        });




    }
    public class MalibuCountDownTimer extends CountDownTimer
    {

        public MalibuCountDownTimer(long startTime, long interval)
        {
            super(startTime, interval);
        }
        @Override
        public void onFinish()
        {
            text.setText("Time's up!");

        }
        @Override
        public void onTick(long millisUntilFinished)
        {
            long result;

            result=millisUntilFinished/60000;


            text.setText(result +" " +"Minutes Left" );

        }
    }

}
