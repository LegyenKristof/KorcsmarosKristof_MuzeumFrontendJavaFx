package com.example.muzeumfrontendjavafx;

public class Festmeny {
    private int id, year;
    private String title;
    private boolean onDisplay;

    public Festmeny(int id, String title, int year, boolean onDisplay) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.onDisplay = onDisplay;
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
        return onDisplay;
    }

    public void setOnDisplay(boolean onDisplay) {
        this.onDisplay = onDisplay;
    }

    @Override
    public String toString() {
        String s = "on display";
        if(!onDisplay) s = "not on display";
        return String.format("%s\t\t%d\t\t%s", title, year, s);
    }
}
