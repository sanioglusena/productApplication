package com.example.shoppingwebapplication.Entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * Entity for uploading data
 */
public class ProductForm extends Product {
    private MultipartFile fileData;

    public ProductForm() {
    }

    public ProductForm(MultipartFile fileData) {
        this.fileData = fileData;
    }

    public MultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }
}
