package com.mediaplayer.com;

import android.database.Cursor;
import android.provider.MediaStore;

/**
 * Created by shrikanth on 10/11/15.
 */
public class MetaInfo {
    String id;
    String name;
    String number_of_songs;
    String albumId;
    enum MODE{
        ALBUM,
        ARTIST,
        PLAYLIST
    }
    MODE mode;

    public MetaInfo(){}
    public MetaInfo(String id, String name, MODE mode) {
        this.id = id;
        this.name = name;
        this.mode = mode;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getNumber_of_songs() {
        return number_of_songs;
    }

    public void setNumber_of_songs(String number_of_songs) {
        this.number_of_songs = number_of_songs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
