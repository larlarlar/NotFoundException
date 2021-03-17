package ru.netology.domain;

import java.util.Objects;

public class Product {

    private int id;
    private String name;
    private int price;


    public String getName() {
        return name;
    }


//    public boolean matches(Product product, String search) {
//        if (product.getName().equalsIgnoreCase(search)) {
//            return true;
//        }
//        return false;
//    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
}

