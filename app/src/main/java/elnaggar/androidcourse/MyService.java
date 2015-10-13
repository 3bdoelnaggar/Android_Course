package elnaggar.androidcourse;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.TaskStackBuilder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Thread.sleep(5000);
            fireNotification();
            Thread.sleep(5000);
            startActivity(new Intent(this, elnaggar.androidcourse.Service.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void fireNotification(){
       NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder=new Notification.Builder(this);
        builder.setContentTitle("How are you");
        builder.setContentText("Are you finr bro");
        builder.setSmallIcon(R.drawable.ic_action_good);
        Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_voice);
        builder.setSound(sound);

        Intent intent=new Intent(this,MainActivity.class);
        TaskStackBuilder taskStackBuilder=TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(MainActivity.class);
        taskStackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
      Notification  notification=builder.getNotification();
        notificationManager.notify(31231,notification);
    }
}
