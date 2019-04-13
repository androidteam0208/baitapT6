package com.example.vantrantrucphuong.quanlyfilm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class FilmEdit extends AppCompatActivity {

    EditText txt_FilmName, txt_FilmSub;
    ImageView imageView;
    Button btn_OK, btn_Cancel;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_edit);
        setControl();
        setEvent();
    }

    private void setEvent() {
//        Intent intent = getIntent();
        FilmCustom filmCustom = (FilmCustom) getIntent().getSerializableExtra("FILM");
//        final int index = intent.getIntExtra("index", 0);
        txt_FilmName.setText(filmCustom.getFilmName());
        txt_FilmSub.setText(filmCustom.getFilmSub());
        imageView.setImageResource(filmCustom.getFilmImage());
        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", txt_FilmName.getText().toString());
                intent.putExtra("sub", txt_FilmSub.getText().toString());
                setResult(1,intent);
                finish();
            }
        });
    }

    private void setControl() {
        txt_FilmName = (EditText) findViewById(R.id.txt_filmName);
        txt_FilmSub = (EditText) findViewById(R.id.txt_FilmSub);
        imageView = (ImageView) findViewById(R.id.filmImage);
        btn_OK = (Button) findViewById(R.id.btn_OK);
    }
}
