package com.mgdapps.audioplayer;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ListView lv_song_listview;
    Button btn_play_Current;
    TextView tv_current_song;
    MediaPlayer mp;


    ArrayList<GetSet> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_song_listview = (ListView) findViewById(R.id.lv_songlistview);

mp=new MediaPlayer();
        songs = new ArrayList<GetSet>();


        getsong();

        Collections.sort(songs, new Comparator<GetSet>() {
            @Override
            public int compare(GetSet lhs, GetSet rhs) {
                return lhs.getSong_name().compareTo(rhs.getSong_name());
            }
        });

        SongAdapter s = new SongAdapter(getApplication(), songs);
        lv_song_listview.setAdapter(s);



        lv_song_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int songindex=position;
                Intent in=new Intent(getApplicationContext(),Songlay.class);


                try {
                    mp.setDataSource(songs.get(songindex).toString());
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                in.putExtra("songindex",songindex);
                setResult(100,in);
                finish();
            }
        });
    }

    public void getsong()
    {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = contentResolver.query(uri, null, null, null, null);

        if (musicCursor != null && musicCursor.moveToFirst()) {
            int titlecolumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int idcolumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media._ID);
            int Artistcolumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            do {
                long thisid = musicCursor.getLong(idcolumn);
                String thistitle = musicCursor.getString(titlecolumn);
                String thisArtist = musicCursor.getString(Artistcolumn);
                songs.add(new GetSet(thisid, thisArtist, thistitle));

            } while (musicCursor.moveToNext());
        }

    }
}

