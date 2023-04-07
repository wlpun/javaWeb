package com.example.jdbc;

public class Pet {
    private int id;
    private int category_id;
    private String title;
    private String tag;
    private String photo;
    private double price;
    private int stock;
    private String descs;
    public Pet() { }
    public int getId() { return id;}
    public void setId(int id) {this.id = id;}
    public int getCategory_id() {return category_id;}
    public void setCategory_id(int category_id) {this.category_id = category_id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getTag() {return tag;}
    public void setTag(String tag) {this.tag = tag;}
    public String getPhoto() {return photo;}
    public void setPhoto(String photo) {this.photo = photo;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}
    public String getDescs() {return descs;}
    public void setDescs(String descs) {this.descs = descs;}
}
