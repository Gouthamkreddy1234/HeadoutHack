package com.androidexample.path.Music;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.androidexample.path.R;

import java.io.File;
import java.io.IOException;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       //done
        requestPermissions(new String[] {Manifest.permission.READ_CONTACTS},
                123);

        //startMusic();
        //displayGenre();//with location
        Log.d("hi","hi");


    }

    private void displayGenre() {

    MusicLibraryScanner.getMusicFromStorage(this);

    }

    private void startMusic() {

                MediaPlayer mPlayer = new MediaPlayer();

        Uri myUri = Uri.parse("/storage/9016-4EF8/kiss.mp3");


        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mPlayer.setDataSource(getApplicationContext(), myUri);
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }



        mPlayer.start();

    }
}
