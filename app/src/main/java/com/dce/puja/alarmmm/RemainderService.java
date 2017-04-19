package com.dce.puja.alarmmm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Devendra on 4/19/2017.
 */

public class RemainderService  extends Service {
    public RemainderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentText("remainder .......")
                .setContentTitle("New Remainder")
                .setSmallIcon(android.R.drawable.ic_btn_speak_now).build();

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(111,notification);
        return START_STICKY;
    }
}


