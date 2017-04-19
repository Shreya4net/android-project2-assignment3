package com.dce.puja.alarmmm;

import android.os.Bundle;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setRemainder(View view){

        EditText text = (EditText) findViewById(R.id.editText);
        int time = Integer.parseInt(text.getText().toString());

        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(MainActivity.this, RemainderService.class);

        PendingIntent pendingIntent = PendingIntent.getService(this,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        //manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+ (time * 1000), pendingIntent);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.set(Calendar.HOUR_OF_DAY, 10+12);
        calendar.set(Calendar.MINUTE, 54);
        manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }
}

