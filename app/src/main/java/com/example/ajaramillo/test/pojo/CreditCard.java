package com.example.ajaramillo.test.pojo;

public class CreditCard {


    private String Name, Information;
    private int Image;

    public CreditCard() {
    }

    public CreditCard(String name, String information, int image) {
        Name = name;
        Information = information;
        Image = image;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
