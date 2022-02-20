package com.example.muzeumfrontendjavafx;

public class Festmeny {
    private int id, year;
    private String title;
    private boolean on_display;

    public Festmeny(int id, String title, int year, boolean on_display) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.on_display = on_display;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOnDisplay() {
        return on_display;
    }

    public void setOnDisplay(boolean onDisplay) {
        this.on_display = onDisplay;
    }

    @Override
    public String toString() {
        String s = "on display";
        if(!on_display) s = "not on display";
        return String.format("%s\t\t%d\t\t%s", title, year, s);
    }
}
