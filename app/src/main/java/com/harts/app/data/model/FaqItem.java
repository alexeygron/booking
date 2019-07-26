package com.harts.app.data.model;

import java.util.ArrayList;
import java.util.List;

public class FaqItem {

    private String title;
    private String text;

    public FaqItem(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<?> getChildItemList() {
        List<String> list = new ArrayList<>();
        list.add(text);
        return list;
    }

    public boolean isInitiallyExpanded() {
        return false;
    }
}
