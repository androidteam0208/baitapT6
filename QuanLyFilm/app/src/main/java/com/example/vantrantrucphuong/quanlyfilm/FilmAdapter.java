package com.example.vantrantrucphuong.quanlyfilm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Van Tran Truc Phuong on 4/13/2019.
 */

public class FilmAdapter extends ArrayAdapter {
    Context context;
    int layoutResourceId;
    ArrayList<FilmCustom> data = null;

    public FilmAdapter(Context context, int layoutResourceId, ArrayList<FilmCustom>data){
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    static class ViewHolder {
        TextView filmName, filmSub;
        ImageView filmImage;
        RatingBar ratingBar;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        ViewHolder viewHolder = null;
        if(row == null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            row = layoutInflater.inflate(layoutResourceId, parent, false);
//            setControl()
            viewHolder = new ViewHolder();
            viewHolder.filmName = (TextView) row.findViewById(R.id.filmName);
            viewHolder.filmSub = (TextView) row.findViewById(R.id.filmSub);
            viewHolder.filmImage = (ImageView) row.findViewById(R.id.filmImage);
            viewHolder.ratingBar = (RatingBar) row.findViewById(R.id.ratingBar);
            row.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) row.getTag();
        }

        FilmCustom filmCustom = data.get(position);
        viewHolder.filmName.setText(filmCustom.getFilmName());
        viewHolder.filmSub.setText(filmCustom.getFilmSub());
        viewHolder.filmImage.setImageResource(filmCustom.getFilmImage());
        return row;
    }
}
