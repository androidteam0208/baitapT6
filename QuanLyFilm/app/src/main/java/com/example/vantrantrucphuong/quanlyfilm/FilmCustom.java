package com.example.vantrantrucphuong.quanlyfilm;

import java.io.Serializable;

/**
 * Created by Van Tran Truc Phuong on 4/6/2019.
 */

public class FilmCustom implements Serializable {
    String filmName, filmSub;
    private int filmImage;

    public FilmCustom( String filmName, String filmSub, int filmImage) {
        this.filmSub = filmSub;
        this.filmImage = filmImage;
        this.filmName = filmName;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmImage() {
        return filmImage;
    }

    public void setFilmImage(int filmImage) {
        this.filmImage = filmImage;
    }

    public String getFilmSub() {
        return filmSub;
    }

    public void setFilmSub(String filmSub) {
        this.filmSub = filmSub;
    }
}
