package com.intellias.marketplaceservice.service;

import com.intellias.marketplaceservice.db.ProductDatabase;
import com.intellias.marketplaceservice.dto.ProductDto;
import com.intellias.marketplaceservice.exception.ProductNotFoundException;
import com.intellias.marketplaceservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private ProductDatabase productDatabase;

    public List<Product> findAll() {
        log.info("Searching for all products");
        return productDatabase.findAll();
    }

    public Product findById(String productId) {
        Product product = productDatabase.findProductById(productId);

        if (product == null) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }

        return product;
    }

    public void add(ProductDto productDto) {
        if (productDto.getPrice() < 0) {
            throw new IllegalArgumentException("Price can not be negative");
        }
        log.info("Add new product with name {} ", productDto.getName());
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setId(UUID.randomUUID());

        productDatabase.save(product);
    }

    public void deleteProduct(String productId) {
        log.info("Trying to delete product with id {}", productId);
        Product product = findById(productId);
        productDatabase.delete(product);
    }
}
