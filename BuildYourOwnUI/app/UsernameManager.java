package com.example.buildyourownui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class UsernameManager {

    private Context ct;
    private SharedPreferences sharedPreferences;
    public UsernameManager(Context ctx){
        ct = ctx;
        sharedPreferences = ct.getSharedPreferences("USER", Context.MODE_PRIVATE);
    }
    public void updateResourceLang(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = ct.getResources();
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        setLang(language);
    }

    public String getLang(){
        return sharedPreferences.getString("lang", "en");

    }
    public void setLang(String language){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("lang", language);
        editor.commit();
    }


    // save state of Radio Buttons
    public void SavePreferencesRB(String key, boolean value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    // Update state of Radio Buttons
    public boolean UpdateRB(String key){
    }



}



