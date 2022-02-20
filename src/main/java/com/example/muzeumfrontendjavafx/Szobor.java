package com.example.muzeumfrontendjavafx;

public class Szobor {
    private int id, height, price;
    private String person;

    public Szobor(int id, String person, int height, int price) {
        this.id = id;
        this.height = height;
        this.price = price;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t%d cm\t\t%d Ft", person, height, price);
    }
}
