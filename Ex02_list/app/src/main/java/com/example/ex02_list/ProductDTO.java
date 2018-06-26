package com.example.ex02_list;

public class ProductDTO {

    private String productName;
    private int price;

    // [Alt + Insert] - [getter/setter, toString(), 기본 생성자, 매개변수 2개 생성자]
    public ProductDTO() { }
    public ProductDTO(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

}