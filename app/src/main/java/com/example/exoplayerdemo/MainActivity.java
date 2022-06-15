package com.example.exoplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

/**
 * ExoPlayer
 */
public class MainActivity extends AppCompatActivity {

    private SimpleExoPlayer simpleExoPlayer;
    private PlayerView playerView;

    public static final String VIDEO_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerView = findViewById(R.id.playView);
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this,new DefaultTrackSelector());
        DefaultDataSourceFactory  defaultDataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this,this.getPackageName()));
        Uri contentUrl = Uri.parse(VIDEO_URL);
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(defaultDataSourceFactory).createMediaSource(contentUrl);
        playerView.setPlayer(simpleExoPlayer);
        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);
        //playerView.requestFocus();





    }
}