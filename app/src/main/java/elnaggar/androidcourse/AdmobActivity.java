package elnaggar.androidcourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class AdmobActivity extends AppCompatActivity {


    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mAdView!=null) {
            mAdView.pause();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mAdView!=null) {
            mAdView.resume();
        }


    }
}
