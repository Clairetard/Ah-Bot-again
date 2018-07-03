package com.example.clair.ahbot;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.media.SoundPool;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class MyNotificationManager {
    private Context context;
    private static MyNotificationManager mInstance;

    private MyNotificationManager(Context c){
        context = c;

    }

    public static synchronized MyNotificationManager getInstance(Context context){
        if(mInstance == null){
            mInstance = new MyNotificationManager(context);
        }
        return mInstance;
    }

    public void displayNotification(String title, String body){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,Constants.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_people_white_24dp)
                .setContentText(body)
                .setContentTitle(title)
                .setAutoCancel(true)  //dismisses the notification on click
                .setDefaults(Notification.DEFAULT_SOUND)
                .setPriority(Notification.PRIORITY_MAX)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setVibrate(new long[]{100,200,300,400,500,400,300,200});

        Intent intent = new Intent(context, ViewRecipe.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intent,PendingIntent.FLAG_UPDATE_CURRENT);


        mBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager != null){
            notificationManager.notify(1, mBuilder.build());
        }
    }
}
