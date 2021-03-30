package com.imran.finhealcapital;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {
    private VideoView vv;
    private String idVideo;
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        vv=findViewById(R.id.videoView);
        pd = new ProgressDialog(this);
        pd.setMessage("Loading");
        pd.setCancelable(false);



        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            pd.show();
            idVideo = bundle.getString("idVideo");
            vv.setVideoPath(idVideo);
            vv.setMediaController(new MediaController(this));
            vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    pd.hide();
                    vv.start();
                }
            });



        }
    }
}