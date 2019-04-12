package com.example.vantrantrucphuong.quanlidanhba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editName, editPhone;
    ListView listViewDanhBa;
    Button btnSaveContact;
    ArrayList<ContactCustom> arrContact = new ArrayList<ContactCustom>();
    ArrayAdapter<ContactCustom> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactCustom contact = new ContactCustom();
                contact.setName(editName.getText()+"");
                contact.setPhone(editPhone.getText()+"");
                arrContact.add(contact);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setControl() {
        editName = (EditText) findViewById(R.id.editName);
        editPhone = (EditText) findViewById(R.id.editPhone);
        listViewDanhBa = (ListView) findViewById(R.id.listViewDanhBa);
        btnSaveContact = (Button) findViewById(R.id.btnSaveContact);
        adapter = new ArrayAdapter<ContactCustom>(this, android.R.layout.simple_list_item_1,arrContact);
        listViewDanhBa.setAdapter(adapter);
    }
}
