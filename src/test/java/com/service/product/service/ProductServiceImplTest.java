package com.service.product.service;

import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void should_create_a_product() {
        //Given
        Product product=Product.builder().id(1L).title("P1").build();

        //When
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        //Then
        Assertions.assertThat(createdProduct).isEqualTo(product);
    }

    @Test
    void findProductById() {
    }

    @Test
    void findAllProducts() {
    }
}