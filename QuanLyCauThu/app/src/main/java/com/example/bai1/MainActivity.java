package com.example.bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<SocialNetwork> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        SetEvent();
    }

    private void SetEvent() {
        KhoiTao();
        SocialNetworkAdapter socialNetworkAdapter = new SocialNetworkAdapter(this, R.layout.listvieew_item_row, list);
        listView.setAdapter(socialNetworkAdapter);
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.listviewSocial);
    }

    private void KhoiTao(){
        list.add(new SocialNetwork(R.drawable.cauthu6, "cầu thủ 1"));
        list.add(new SocialNetwork(R.drawable.cauthu2, "cầu thủ 2"));
        list.add(new SocialNetwork(R.drawable.cauthu3, "cầu thủ 3"));
        list.add(new SocialNetwork(R.drawable.cauthu1, "cầu thủ 4"));
        list.add(new SocialNetwork(R.drawable.cauthu5, "cầu thủ 5"));
    }
}
