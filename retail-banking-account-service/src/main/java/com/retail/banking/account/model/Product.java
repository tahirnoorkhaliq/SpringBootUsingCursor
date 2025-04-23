package com.retail.banking.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;
    
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rating {
        private Double rate;
        private Integer count;
    }
} 