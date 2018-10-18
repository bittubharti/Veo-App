package com.imo.netset.veo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *..... Created by netset on 23/6/16.
 */
public class Gender_Selection extends Activity implements View.OnClickListener {
    ImageView male_image,female_image,male_icon,female_icon,both_icon;
Button button;

    TextView textView_terms1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_activity);
        male_image=(ImageView)findViewById(R.id.male);
        female_image=(ImageView)findViewById(R.id.female);
        male_icon=(ImageView)findViewById(R.id.male_id);
        female_icon=(ImageView)findViewById(R.id.female_id);
        both_icon=(ImageView)findViewById(R.id.both_id);
        textView_terms1=(TextView)findViewById(R.id.terms1);
        button=(Button)findViewById(R.id.button);

        male_image.setOnClickListener(this);
        female_image.setOnClickListener(this);
        male_icon.setOnClickListener(this);
        female_icon.setOnClickListener(this);
        both_icon.setOnClickListener(this);
        button.setOnClickListener(this);
        textView_terms1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.male:
                male_image.setBackgroundResource(R.drawable.selected2);
                female_image.setBackgroundResource(R.drawable.female);
                break;
            case R.id.female:
                male_image.setBackgroundResource(R.drawable.male);
                female_image.setBackgroundResource(R.drawable.selected1);
                break;
            case R.id.male_id:
                male_icon.setBackgroundResource(R.drawable.selected2);
                female_icon.setBackgroundResource(R.drawable.female);
                both_icon.setBackgroundResource(R.drawable.both);
                break;
            case R.id.female_id:
                male_icon.setBackgroundResource(R.drawable.male);
                female_icon.setBackgroundResource(R.drawable.selected1);
                both_icon.setBackgroundResource(R.drawable.both);
                break;
            case R.id.both_id:
                male_icon.setBackgroundResource(R.drawable.male);
                female_icon.setBackgroundResource(R.drawable.female);
                both_icon.setBackgroundResource(R.drawable.selected3);
                break;

            case R.id.button:
                Intent intent = new Intent(Gender_Selection.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.terms1:

                Intent intent_service= new Intent(Gender_Selection.this,Terms_of_Service.class);
                startActivity(intent_service);
                finish();
                break;


        }

    }



}




