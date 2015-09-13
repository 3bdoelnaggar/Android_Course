package elnaggar.androidcourse;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {
    NotificationManager notificationManager;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder=new Notification.Builder(this);
        builder.setContentTitle("How are you");
        builder.setContentText("Are you finr bro");
        builder.setSmallIcon(R.drawable.ic_action_good);
        Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_voice);
        builder.setSound(sound);

        Intent intent=new Intent(this,MainActivity.class);
        TaskStackBuilder taskStackBuilder=TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(this);
        taskStackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
        notification=builder.getNotification();


    }



    public void onClick(View view) {
        notificationManager.notify(1234,notification);
    }
}
