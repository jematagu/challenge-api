package com.entrevista.service;

import com.entrevista.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product saveProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
