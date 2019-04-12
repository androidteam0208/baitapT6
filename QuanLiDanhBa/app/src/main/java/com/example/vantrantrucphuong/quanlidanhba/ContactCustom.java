package com.example.vantrantrucphuong.quanlidanhba;

/**
 * Created by Van Tran Truc Phuong on 4/6/2019.
 */

public class ContactCustom {
    private String name;
    private String phone;

    public ContactCustom(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public ContactCustom() {

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name+"["+this.phone+"]";
    }
}
