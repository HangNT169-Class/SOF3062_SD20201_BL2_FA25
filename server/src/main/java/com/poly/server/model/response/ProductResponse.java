package com.poly.server.model.response;

import com.poly.server.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    // Product ID, Product Code, Product Name, Price, Category Code, Category Name
    private Long pId;
    private String pCode;
    private String pName;
    private Double price;
    private String cateCode;
    private String cateName;
    public ProductResponse(Product p) {
        this.pId = p.getId();
        this.pCode = p.getProductCode();
        this.pName = p.getProductName();
        this.price = p.getPrice();
        // Join
        this.cateCode = p.getCategory().getCategoryCode();
        this.cateName = p.getCategory().getCategoryName();
    }
}
