package com.putracode.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by krisna putra on 10/28/2017.
 */
@Data
@AllArgsConstructor
public class Product {
    private String id;
    private String code;
    private String name;
    private Long stock;

}
