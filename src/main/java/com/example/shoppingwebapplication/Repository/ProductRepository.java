package com.example.shoppingwebapplication.Repository;

import com.example.shoppingwebapplication.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Page<Product> findAll(Pageable pageable);

    Product findById(int Id);
}
