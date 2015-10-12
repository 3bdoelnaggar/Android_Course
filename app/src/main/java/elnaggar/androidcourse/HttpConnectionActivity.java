package elnaggar.androidcourse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HttpConnectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_connection);
    }
    public void onClick(View view) {
        if(ConnectionManager.isIntenetConectted(this)) {
            httpTask httpTask = new httpTask(this);
            httpTask.execute("https://api.github.com/user/3bdoelnaggar");
        }else
            Toast.makeText(this,"Please check internet",Toast.LENGTH_SHORT).show();

    }
}
