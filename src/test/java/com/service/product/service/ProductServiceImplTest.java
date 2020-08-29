package com.service.product.service;

import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;
import org.assertj.core.data.Index;
<<<<<<< HEAD
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.hamcrest.CoreMatchers;
=======
>>>>>>> c3d36b7... Add TU for find all products
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
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
    void should_return_a_list_of_all_products() {
        //Given
        Product p1 = Product.builder().id(1L).title("P1").build();
        List<Product> products= Arrays.asList(p1);

        //When
        when(productRepository.findAll()).thenReturn(products);

        List<Product> allProducts = productService.findAllProducts();

        verify(productRepository,times(1)).findAll();

        //Then
        assertThat(allProducts).contains(p1, Index.atIndex(0));

        Mockito.when(productRepository.save(product)).thenReturn(product);

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
    void should_return_a_list_of_all_products() {
        //Given
        Product p1 = Product.builder().id(1L).title("P1").build();
        List<Product> products= Arrays.asList(p1);

        //When
        when(productRepository.findAll()).thenReturn(products);

        List<Product> allProducts = productService.findAllProducts();

        verify(productRepository,times(1)).findAll();

        //Then
        assertThat(allProducts).contains(p1, Index.atIndex(0));
    }
}
