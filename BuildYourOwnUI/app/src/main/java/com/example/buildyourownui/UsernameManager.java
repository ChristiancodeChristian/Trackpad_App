package com.example.buildyourownui;

import android.content.Context;
import android.content.SharedPreferences;

public class UsernameManager {

    private Context ct;
    private SharedPreferences sharedPreferences;
    public UsernameManager(Context ctx){
        ct = ctx;
        sharedPreferences = ct.getSharedPreferences("USER", Context.MODE_PRIVATE);
    }

    public String getUser(){
        return sharedPreferences.getString("user", null);
    }

    public void setUser(String username){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putString("user", username);
        editor.apply();
    }


}
