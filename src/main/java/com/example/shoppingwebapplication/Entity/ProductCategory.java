package com.example.shoppingwebapplication.Entity;

public enum ProductCategory {
    Clothing("Cloth"),
    Accessories("Jewelry"),
    Shoes("Shoe"),
    Bags("Bag");

    private final String value;

    ProductCategory(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    @Override
    public String toString() {
        return value();
    }
}
