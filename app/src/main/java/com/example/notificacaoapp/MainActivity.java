package com.example.notificacaoapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {
    Button btnNotification;

    private static final String CHANNEL_ID = "simplified_coding";
    private static final String CHANNEL_NAME = "Simplified_Coding";
    private static final String CHANNEL_DESC = "Simplified Coding Notifications";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotification = findViewById(R.id.btnNotification);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }



        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification();
            }
        });




    }

    private void displayNotification() {
        /*NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_action_name)
                .setContentTitle("Titulo da notification")
                .setContentText("Mensagem da notification")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat mNotificationMG = NotificationManagerCompat.from(this);
        mNotificationMG.notify(1, builder.build());*/


        Intent intent = new Intent(this, NotificationActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,0);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String notificationChanelId = "my_chanel_id_01";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChanel = new NotificationChannel(notificationChanelId, "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            notificationChanel.setDescription("Channel description");
            notificationChanel.enableLights(true);
            notificationChanel.setLightColor(Color.RED);

            notificationManager.createNotificationChannel(notificationChanel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, notificationChanelId);

        builder.setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Titulo da notificacao")
                .setContentText("Texto da notificacao")
                .setContentIntent(pendingIntent);

        notificationManager.notify(1,builder.build());


    }
}