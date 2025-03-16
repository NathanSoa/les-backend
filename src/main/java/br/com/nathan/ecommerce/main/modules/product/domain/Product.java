package br.com.nathan.ecommerce.main.modules.product.domain;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private String photoUrl;
    private boolean active;

    private Product() { }

    public static Product Create() {
        return new Product();
    }

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    public Product withPrice(Double price) {
        this.price = price;
        return this;
    }

    public Product withId(Long id) {
        this.id = id;
        return this;
    }

    public Product withActive(boolean active) {
        this.active = active;
        return this;
    }

    public Product withPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }
}
