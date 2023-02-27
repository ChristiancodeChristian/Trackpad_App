package com.example.buildyourownui;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsManager {

    private Context ct;
    private SharedPreferences BTNsharedPreferences;
    public SettingsManager(Context ctx){
        ct = ctx;
        BTNsharedPreferences = ct.getSharedPreferences("BTN", Context.MODE_PRIVATE);
    }


    public void setBTNpref(boolean Easy, boolean Sounds, boolean BackgroundMusic) {
        //SharedPreferences BTNsharedPreferences = getSharedPreferences("btn", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = BTNsharedPreferences.edit();
        editor.clear();
        editor.putBoolean("switchEasyHard", Easy);
       //editor.putString("StringEasyHard", ScoreActivity.difficulty_score);
        editor.putBoolean("btnBackgroundMusic", BackgroundMusic);
        editor.putBoolean("btnSounds", Sounds);
        editor.apply();
    }

    public boolean updateBTN(String key){
        return BTNsharedPreferences.getBoolean(key, false);
    }

    public boolean updateBTNBackgroundMusic(){
        boolean testBackgroundMusic = BTNsharedPreferences.getBoolean("btnBackgroundMusic", false);
        return testBackgroundMusic;
    }
    public boolean updateBTNSounds(){
        boolean testSounds = BTNsharedPreferences.getBoolean("btnSounds", false);
        return testSounds;
    }
    public boolean updateEasyHard(){
        boolean testEasyHard = BTNsharedPreferences.getBoolean("switchEasyHard", false);
        return testEasyHard;
    }


    public String getDifficultyMode(){
        return BTNsharedPreferences.getString("StringEasyHard", null);
    }


}