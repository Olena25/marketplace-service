package com.intellias.marketplaceservice.db;

import com.intellias.marketplaceservice.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ProductDatabase {

    private List<Product> products = new ArrayList<>();

    public List<Product> findAll(){
        return products;
    }

    public void save(Product product){
        log.info("Saving product {} to database", product.getId());
        products.add(product);
    }

}
