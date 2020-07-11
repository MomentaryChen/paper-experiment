package com.example.hw4;

public class Good {
  private String name;
  private int price;
  private int image;
  private String description;

  public Good(String name, int price, String description, int image) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.image = image;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
