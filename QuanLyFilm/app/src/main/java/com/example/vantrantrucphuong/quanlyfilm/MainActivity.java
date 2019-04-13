package com.example.vantrantrucphuong.quanlyfilm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewFilm;
    Button btn;
    static int index ;
    static ArrayList<FilmCustom> filmArray = new ArrayList<>();
    FilmAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setControl() {
        listViewFilm = (ListView) findViewById(R.id.listViewFilm);
        btn = (Button) findViewById(R.id.btn_Reload);
    }

    private void setEvent() {
        khoiTao();
        listViewAdapter = new FilmAdapter(this,R.layout.list_item_row, filmArray);
        listViewFilm.setAdapter(listViewAdapter);
        listViewFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), FilmEdit.class);
                intent.putExtra("FILM", filmArray.get(i));
                index = i;
                startActivityForResult(intent, 1);
            }
        });

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = getIntent();
//                String name = intent.getStringExtra("name");
//                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//                String sub = intent.getStringExtra("sub");

//            }
//        });
        listViewAdapter.notifyDataSetChanged();

    }
    // Khi kết quả được trả về từ Activity khác, hàm onActivityResult sẽ được gọi.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Kiểm tra requestCode có trùng với REQUEST_CODE vừa dùng
        // resultCode được set bởi DetailActivity
        // RESULT_OK chỉ ra rằng kết quả này đã thành công
        if(requestCode == 1) {
            String name = data.getStringExtra("name");
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, String.valueOf(index), Toast.LENGTH_SHORT).show();
                String sub = data.getStringExtra("sub");
                filmArray.get(index).setFilmName(name);
                filmArray.get(index).setFilmSub(sub);
//                listViewFilm.setAdapter(listViewAdapter);
                listViewAdapter.notifyDataSetChanged();
        }
    }

    private void khoiTao() {
        filmArray.add(new FilmCustom("SuperGirl", "(Nữ siêu nhơn)", R.drawable.supergirl));
        filmArray.add(new FilmCustom("Chị Mười Ba", "(Chị 13)", R.drawable.chimuoba));
    }
}
