package com.example.demo2513.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String email;
    private String name;
    private String address;
    private List<CartItem> listorder;
    private String orderdate;
    private String phone;

    private String giamgia;

    public void setListorder(List<CartItem> listorder) {
        this.listorder = listorder;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CartItem> getListorder() {
        return listorder;
    }

    public void setListorder(ArrayList<CartItem> listorder) {
        this.listorder = listorder;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
