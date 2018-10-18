package com.imo.netset.veo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class GeneralValues {
	static SharedPreferences preferences;
	static SharedPreferences.Editor editor;




	public static void set_checkvalue(Activity activity, String id) {

		preferences = PreferenceManager.getDefaultSharedPreferences(activity);
		editor = preferences.edit();
		editor.putString("user_id", id);
		editor.commit();

	}

	public static String get_checkvalue(Activity activity) {
		preferences = PreferenceManager.getDefaultSharedPreferences(activity);
		String user_id = preferences.getString("user_id", "");
		return user_id;
	}






 



	
	




}
