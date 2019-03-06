package com.lotr.booking.data.model;

public class WithdrawalItem {

    private String date;
    private String sum;
    private String target;

    public WithdrawalItem(String date, String sum, String target) {
        this.date = date;
        this.sum = sum;
        this.target = target;
    }

    public WithdrawalItem() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
