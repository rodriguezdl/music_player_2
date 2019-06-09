package com.example.daniel.music_player_2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class MusicService extends Service {
    private MediaPlayer player = new MediaPlayer();
    public IBinder onBind(Intent intent){
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
       player.setLooping(true);
       player.start();
       return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }
}
