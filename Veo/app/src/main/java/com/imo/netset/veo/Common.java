package com.imo.netset.veo;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Common {
/*	public static int userid(Context c){
		int userid=0;
		*//*SharedPreferences sp=c.getSharedPreferences(Settings.Global.PREF_LOGIN, Context.MODE_PRIVATE);
		int keepme=sp.getInt(Settings.Global.KEEP_ME_CHECK,0);
		if(keepme==1){userid=sp.getInt(Settings.Global.USER_ID,0);}
		else{AllGetterSetter getterSetter=new AllGetterSetter();*//*

		userid=getterSetter.getUserid();
		}
		return  userid;
	}*/
	public  String saveToInternalStorage(Context c,Bitmap bitmapImage,String filename){
		ContextWrapper cw = new ContextWrapper(c);
		File directory = cw.getDir("images", Context.MODE_PRIVATE);
		File mypath=new File(directory,filename);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(mypath);
			// Use the compress method on the BitMap object to write image to the OutputStream
			bitmapImage.compress(Bitmap.CompressFormat.PNG, 80, fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return directory.getAbsolutePath()+"/"+filename;
	}
}

