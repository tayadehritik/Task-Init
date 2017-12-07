package com.example.kali.just_testing;

import android.os.Vibrator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyBrodcastRec extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(1000);
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.b);
        mediaPlayer.start();
        Toast.makeText(context, "Alarm", Toast.LENGTH_LONG).show();
    }
}
