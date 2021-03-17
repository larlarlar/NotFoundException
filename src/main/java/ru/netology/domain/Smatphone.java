package ru.netology.domain;

import java.util.Objects;

public class Smatphone extends Product {
    private String manufacturer;


    public Smatphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

//    public boolean matches(Product product, String search) {
//        if (super.matches(product, search)) {
//            return true;
//        }
//        if (product instanceof Smatphone) {
//            Smatphone smatphone = (Smatphone) product;
//            if (smatphone.getManufacturer().equalsIgnoreCase(search)) {
//                return true;
//            }
//        }
//        return false;
//    }

}
