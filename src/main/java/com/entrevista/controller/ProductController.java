package com.entrevista.controller;

import com.entrevista.entity.Product;
import com.entrevista.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    List<Product> getAll(){
        return productService.findAll();
    }

    @PostMapping("/product")
    Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    Product updateProduct(@PathVariable(value = "id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/product")
    void deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
    }

}
