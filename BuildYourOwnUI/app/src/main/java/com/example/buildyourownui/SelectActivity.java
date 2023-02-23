package com.example.buildyourownui;

        import android.content.Intent;
        import android.media.MediaPlayer;
//import android.support.v7.app.LoginActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class SelectActivity extends AppCompat {
    // initializing variables
    private Button BTN_mobile;
    private Button BTN_tp;

    //private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        // Load the music file from the app's resources
        //mediaPlayer = MediaPlayer.create(this, R.raw.ES_Sunny_Field_With_Birds_Organic_Nature_Sounds_1);

        // Loop the music continuously
        //mediaPlayer.setLooping(true);

        // Start playing the music
        //mediaPlayer.start();

        };

    private void launchMainActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

   /* @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop and release the MediaPlayer when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }*/

}