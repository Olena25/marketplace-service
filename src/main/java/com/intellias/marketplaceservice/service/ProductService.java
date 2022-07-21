package com.intellias.marketplaceservice.service;

import com.intellias.marketplaceservice.db.ProductDatabase;
import com.intellias.marketplaceservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private ProductDatabase productDatabase;

    public List<Product> findAll(){
        log.info("Searching for all products");
        return productDatabase.findAll();
    }
}
