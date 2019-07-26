package com.harts.app.data.model;

public class PurchaseItem {

    private String date;
    private String price;

    public PurchaseItem(String date, String price) {
        this.date = date;
        this.price = price;
    }

    public PurchaseItem() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
