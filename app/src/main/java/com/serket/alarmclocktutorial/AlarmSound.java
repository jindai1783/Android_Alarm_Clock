package com.serket.alarmclocktutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import java.io.IOException;

/**
 * Created by daijin on 07/03/2015.
 */
public class AlarmSound extends Activity {

  private MediaPlayer player;
  final Context context = this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      Log.v("Tag1", "We entered on Create");
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.alarm_layout);

    Button stop = (Button) findViewById(R.id.alarm);
    stop.setOnTouchListener(new View.OnTouchListener() {
      public boolean onTouch(View arg0, MotionEvent arg1) {
        player.stop();
        Intent i = new Intent(context, Bye.class);
        startActivity(i);
        return false;
      }
    });

    play(this, getAlarmSound());
    }

    private void play(Context context, Uri alert) {

        Log.v("Tag1", "We entered play");
      player = new MediaPlayer();
      try {
        player.setDataSource(context, alert);
        final AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (audio.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
          player.setAudioStreamType(AudioManager.STREAM_ALARM);
          player.prepare();
          player.start();
        }

      } catch (IOException e) {
        Log.e("Error...", "Check code...");
      }
    }

    private Uri getAlarmSound() {

      Log.v("Tag1", "We entered getAlarmSound");

        Uri alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
      if (alertSound == null) {
        alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if (alertSound == null) {
          alertSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        }
      }
      return alertSound;
    }


}
