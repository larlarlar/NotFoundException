package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product item) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product[] findByID(int id) {
        Product[] result = new Product[1];
        for (Product product : products) {
            if (product.getId() == id) {
                result[0] = product;
            }
        }
        if (result[0] == null) {
            throw new NotFoundException("Element with ID " + id + " not found");
        } else return result;
    }

    public void removeByID(int id) {
        try {
            findByID(id);
            int length = products.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : products) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
                products = tmp;
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}

