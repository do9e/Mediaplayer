package com.mediaplayer.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mediaplayer.com.MetaInfo;
import com.mediaplayer.com.R;
import com.mediaplayer.com.SongInfo;
import com.mediaplayer.db.SongInfoDatabase;
import com.mediaplayer.manager.BroadcastManager;
import com.mediaplayer.utility.AlbumArtLoader;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by shrikanth on 10/2/15.
 */
public class AlbumsFragment extends MultiviewFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        gridview.setOnItemClickListener(this);
        return v;

    }

    @Override
    public void setTitle() {
        getActivity().setTitle(getString(R.string.albums));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setData() {
        database =  SongInfoDatabase.getInstance();
        list = new ArrayList<MetaInfo>();
        list = database.getAlbums(null);
    }

    @Override
    public void setMode() {
        mode = AlbumArtLoader.Mode.ALBUM;
    }

    @Override
    public ArrayList<SongInfo> getToBePlayedData(MetaInfo info) {
        SongInfoDatabase db =  SongInfoDatabase.getInstance();
        return db.getSongsForAlbum(info);
    }

    @Override
    public void searchSongs(String search) {
        list = database.getAlbums(search);
        adapter.addAll(list);
    }

}
