package com.serket.alarmclocktutorial;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import java.util.Calendar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        Calendar t = Calendar.getInstance();
        t.add(Calendar.SECOND, 10);

        Log.v("Tag1", "This is the test number 1");

        Intent i = new Intent(this, AlarmSound.class);
        PendingIntent pending = PendingIntent.getActivity(this, 1235, i, PendingIntent.FLAG_CANCEL_CURRENT);

        Log.v("Tag1", "This is the test number 2, yeah");

        AlarmManager alarm = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);

        Log.v("Tag1", "This is the test number 3, yeah");

        alarm.set(AlarmManager.RTC_WAKEUP, t.getTimeInMillis(), pending);
//        startActivity(intent);

        Log.v("Tag1", "This is the test number 4, yeah");
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
