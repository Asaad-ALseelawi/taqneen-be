package com.products.controller;



import com.products.repository.ProductRepo;
import com.products.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepo repo;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);



    @PostMapping("/product")
    @CacheEvict(value = "productList", allEntries = true)
    public Product createProduct(@RequestBody Product product){
        logger.info("Creating product");
        return repo.save(product);
    }

    @GetMapping("/products/")
    @Cacheable("productList")
    public List<Product> getProducts(){
        logger.info("Retrieving all products");
        return repo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        logger.info("Retrieving product with id {}", id);
        return repo.findById(id).isPresent() ? repo.findById(id).get() : new Product();
    }

    @PutMapping("/products")
    @CacheEvict(value = "productList", allEntries = true)
    public Product updateProduct(@RequestBody Product product){
        logger.info("Updating product");
        return repo.save(product);

    }

    @DeleteMapping("/products/{id}")
    @CacheEvict(value = "productList", allEntries = true)
    public void deleteProduct(@PathVariable("id") int id){
        logger.info("Deleting product with id {}", id);
        repo.deleteById(id);
    }

}
