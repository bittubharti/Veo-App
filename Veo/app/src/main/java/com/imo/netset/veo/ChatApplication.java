package com.imo.netset.veo;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.interceptors.ParseLogInterceptor;

/**
 * Created by netset on 6/7/16.
 */
public class ChatApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("zuzGsbbrdBK3u25erXZ9Htb9q5SGA5JY8lH0gNTM") // should correspond to APP_ID env variable
                .addNetworkInterceptor(new ParseLogInterceptor())
                .server("https://myparseapp.herokuapp.com/parse/").build());


        ParseObject.registerSubclass(Message.class);
        // Existing initialization happens after all classes are registered

        // For open-source Parse backend
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("zuzGsbbrdBK3u25erXZ9Htb9q5SGA5JY8lH0gNTM") // should correspond to APP_ID env variable
                .addNetworkInterceptor(new ParseLogInterceptor())
                .server("https://myparseapp.herokuapp.com/parse/").build());


    }


}
