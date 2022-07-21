package com.intellias.marketplaceservice.db;

import com.intellias.marketplaceservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDatabase {

    private List<Product> products = new ArrayList<>();

    public List<Product> findAll(){
        return products;
    }

}
