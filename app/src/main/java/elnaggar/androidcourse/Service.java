package elnaggar.androidcourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void startService(View view) {
        startService(new Intent(this,MyService.class));
        finish();



    }

    public void stopService(View view) {
        stopService(new Intent(this,MyService.class));

    }
}
