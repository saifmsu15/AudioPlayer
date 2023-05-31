package com.mgdapps.audioplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Songlay extends AppCompatActivity {

    Button btn_back,btn_playlist,btn_previous,btn_rewind,btn_play,btn_forward,btn_next,btn_shuffle,btn_repeat;
    TextView tv_songtitle,tv_songlength,tv_song_totallength;
    SeekBar seek_song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlay);

        btn_back=(Button)findViewById(R.id.btn_back);
        btn_playlist=(Button)findViewById(R.id.btn_Playlist);
        btn_previous=(Button)findViewById(R.id.btn_previous);
        btn_rewind=(Button)findViewById(R.id.btn_rewind);
        btn_forward=(Button)findViewById(R.id.btn_forward);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_play=(Button)findViewById(R.id.btn_play);
        btn_shuffle=(Button)findViewById(R.id.btn_shuffle);
        btn_repeat=(Button)findViewById(R.id.btn_repeat);


        tv_songtitle=(TextView)findViewById(R.id.tv_songTitle);
        tv_songlength=(TextView)findViewById(R.id.tv_song_currentlength);
        tv_song_totallength=(TextView)findViewById(R.id.tv_song_totallength);

        seek_song=(SeekBar)findViewById(R.id.seek_seekbar);
    }
}
