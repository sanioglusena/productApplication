package com.example.shoppingwebapplication.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Product entity class.
 * Registered users are allowed to add products into the application.
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String category;

    @Lob
    private byte[] image;

    private BigDecimal price;
    private Date creationDate;
    private boolean removed;

    public Product() {
    }

    public Product(String name, String category, byte[] image, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.price = price;
        this.creationDate = new Date(System.currentTimeMillis());
        this.removed = false;
    }

    public int getId() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
