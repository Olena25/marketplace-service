package com.intellias.marketplaceservice.model;


import lombok.Data;

import java.util.UUID;

@Data
public class Product {
    private UUID id;
    private String name;
    private long price;
}
