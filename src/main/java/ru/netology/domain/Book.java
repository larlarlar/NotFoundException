package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;


    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

//    public boolean matches(Product product, String search) {
//        if (super.matches(product, search)) {
//            return true;
//        }
//        if (product instanceof Book) {
//            Book book = (Book) product;
//            if (book.getAuthor().equalsIgnoreCase(search)) {
//                return true;
//            }
//        }
//        return false;
//    }

}
