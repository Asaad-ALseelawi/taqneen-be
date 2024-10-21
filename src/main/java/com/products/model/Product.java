package com.products.model;

import jakarta.persistence.*;

@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_Id")
    private int id;

    @Column(name = "Product_Name")
    private String name;

    @Column(name = "Product_Desc")
    private String description;

    @Column(name = "Product_Price")
    private double price;

    public Product() {

    }



    public Product(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public long getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }
}
