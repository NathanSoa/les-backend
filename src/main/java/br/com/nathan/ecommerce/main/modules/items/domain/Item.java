package br.com.nathan.ecommerce.main.modules.items.domain;

import br.com.nathan.ecommerce.main.modules.product.domain.Product;
import lombok.Data;

@Data
public class Item {
    private Long id;
    private Product product;
    private String code;
    private Status status;

    private Item() { }

    public static Item Create() {
        return new Item();
    }

    public Item withProduct(Product product) {
        this.product = product;
        return this;
    }

    public Item withCode(String code) {
        this.code = code;
        return this;
    }

    public Item withId(Long id) {
        this.id = id;
        return this;
    }

    public Item withStatus(Status status) {
        this.status = status;
        return this;
    }
}
