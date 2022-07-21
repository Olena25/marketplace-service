package com.intellias.marketplaceservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
private UUID id;
private String firstName;
private String lastName;
private long amountOfMoney;
}
