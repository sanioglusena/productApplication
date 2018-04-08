package com.example.shoppingwebapplication.Services;

import com.example.shoppingwebapplication.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Page<Product> getAllProducts(Pageable page);

    void saveProduct(Product product);

    Product findProductById(int productId);

}
