package elnaggar.androidcourse;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SplashActivity extends Activity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread timer =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    mediaPlayer=MediaPlayer.create(SplashActivity.this,R.raw.splash_voice);
//                    mediaPlayer.start();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent=new Intent(SplashActivity.this,Menu.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mediaPlayer.release();
    }
}
