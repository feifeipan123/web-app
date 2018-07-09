package com._520it.shopping.domain;

import java.math.BigDecimal;

import lombok.Data;

/**
 *��Ʒ����
 */
@Data
public class Product {
     private Long id;
     private String productName;
     private String brand;
     private String supplier;
     private BigDecimal salePrice;
     private BigDecimal costPrice;
     private Double cutoff;
     private Long dir_id;
}
