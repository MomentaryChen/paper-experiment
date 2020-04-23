package com.example.hw4;

public class Good {
    private String names;
    private int prices;

    public Good(String names, int prices, int images) {
        this.names = names;
        this.prices = prices;
        this.images = images;
    }

    private int images;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
