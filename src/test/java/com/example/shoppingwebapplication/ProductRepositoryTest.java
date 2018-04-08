package com.example.shoppingwebapplication;

import com.example.shoppingwebapplication.Entity.Product;
import com.example.shoppingwebapplication.Repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenfindById_thenReturnProduct() {
        // given
        Product product = new Product();
        product.setName("prod1");
        product.setCategory("cat");

        entityManager.persist(product);
        entityManager.flush();

        // when
        Product found = productRepository.findById(product.getId());

        // then
        assertNotNull(found);
    }

    @Test
    public void whenfindAll_thenReturnUserList() {
        // given
        // product 1
        Product p1 = new Product();
        p1.setName("prod1");
        p1.setCategory("cat");

        // product 2
        Product p2 = new Product();
        p2.setName("prod2");
        p2.setCategory("cat");

        // product 3
        Product p3 = new Product();
        p3.setName("prod3");
        p3.setCategory("cat");

        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
        entityManager.flush();

        // when
        Page<Product> productList = productRepository.findAll(new PageRequest(0, 20));

        // then
        assertThat(productList.stream().toArray().length)
                .isEqualTo(3);
    }

}
