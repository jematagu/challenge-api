package com.entrevista.service;

import com.entrevista.entity.Product;
import com.entrevista.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService implements ProductService{

    ProductRepository productRepository;

    public ProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct( Long id, Product newProduct) {
        Optional<Product> product = findById(id);

        product.orElseThrow(RuntimeException::new).setName(newProduct.getName());
        product.orElseThrow(RuntimeException::new).setPrice(newProduct.getPrice());
        product.orElseThrow(RuntimeException::new).setPicture(newProduct.getPicture());

        return productRepository.save(product.orElse(new Product()));
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
