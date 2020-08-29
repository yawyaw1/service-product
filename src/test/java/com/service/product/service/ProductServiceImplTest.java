package com.service.product.service;

import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void should_create_a_product() {
        //Given
        Product product=Product.builder().id(1L).title("P1").build();

        //When
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = productService.create(product);

        verify(productRepository,times(1)).save(any(Product.class));

        //Then
        assertThat(createdProduct).isEqualTo(product);
    }

    @Test
    void should_return_a_product_by_its_id() {
        //Given
        Product product=Product.builder().id(1L).title("P1").build();

        //when
        when(productRepository.findById(any())).thenReturn(Optional.of(product));

        Product productById = productService.findProductById(1L);

        verify(productRepository,times(1)).findById(any());

        //Then
        assertThat(productById).isEqualTo(product);
    }

    @Test
    void findAllProducts() {
    }
}