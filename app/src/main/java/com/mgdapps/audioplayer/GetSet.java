package com.mgdapps.audioplayer;

/**
 * Created by HP on 10/11/2016.
 */

public class GetSet {

    private  long song_id;
    private String song_name;
    private String song_artist;

    public long getSong_id() {
        return song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public String getSong_artist() {
        return song_artist;
    }

    public GetSet(long song_id, String song_name, String song_artist)
    {
        this.song_id=song_id;
        this.song_name=song_name;
        this.song_artist=song_artist;
    }

}
