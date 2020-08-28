package com.service.product.service;

import com.service.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);

    Product findProductById(Long id);

    List<Product> findAllProducts();
}
