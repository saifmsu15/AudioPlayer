package com.mgdapps.audioplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HP on 10/11/2016.
 */

public class SongAdapter extends BaseAdapter
{
    int resource;
    ArrayList<GetSet> songlist;
    LayoutInflater inflater;

    @Override
    public int getCount() {
        return songlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public SongAdapter(Context ctx, ArrayList<GetSet> thesong)
    {
        songlist=thesong;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RelativeLayout songlay= (RelativeLayout) inflater.inflate(R.layout.row,parent,false);

        TextView tv_rowtitle=(TextView)songlay.findViewById(R.id.tv_rowtitle);
        TextView tv_rowartist=(TextView)songlay.findViewById(R.id.tv_rowartist);

        GetSet currsong=songlist.get(position);

        tv_rowtitle.setText(currsong.getSong_artist());
        tv_rowartist.setText(currsong.getSong_name());
        songlay.setTag(position);

        return songlay;
    }


}
