package com.service.product.service;

import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        log.info("Creating a product");
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        log.info("Find a product by id");
        return productRepository.findById(id).orElse(null);
    }

    @Cacheable(cacheNames = "productList")
    @Override
    public List<Product> findAllProducts() {
        log.info("******Retrieve from database*****");
        return productRepository.findAll();
    }
}
