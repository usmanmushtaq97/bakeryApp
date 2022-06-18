package com.tss.bakeryapp;

import java.util.List;

public class ProductModel {
    int id;
    int price;
    String productTitle;
    int productQty;
    int ProductImage;
    public ProductModel(int id, int price, String productTitle, int productQty, int productImage) {
        this.id = id;
        this.price = price;
        this.productTitle = productTitle;
        this.productQty = productQty;
        ProductImage = productImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public int getProductImage() {
        return ProductImage;
    }
    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }
}