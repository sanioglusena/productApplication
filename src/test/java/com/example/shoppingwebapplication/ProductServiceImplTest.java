package com.example.shoppingwebapplication;

import com.example.shoppingwebapplication.Entity.Product;
import com.example.shoppingwebapplication.Repository.ProductRepository;
import com.example.shoppingwebapplication.Services.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    private ProductRepository productRepository = mock(ProductRepository.class);
    private ProductServiceImpl productService;

    @Before
    public void setUp() {
        Product product = new Product();
        product.setName("product");
        product.setCategory("cat");

        Product product2 = new Product();
        product2.setName("product2");
        product2.setCategory("cat2");

        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        productList.add(product2);

        Page<Product> productPage = new PageImpl<Product>(productList);
        when(productRepository.findAll(Mockito.any())).thenReturn(productPage);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void whengetAllProducts_thenReturnProductList() {
        assertNotNull(productService.getAllProducts(new PageRequest(0, 20)));
        Page<Product> productPage = productService.getAllProducts(new PageRequest(0, 20));

        assertEquals(productPage.getTotalPages(), 1);
        assertEquals(productPage.getTotalElements(), 2);
    }
}
