package br.com.nathan.ecommerce.main.modules.cardFlag.domain;

import lombok.Data;

@Data
public class Flag {

    private String name;

    private Flag() {}

    public static Flag Create() {
        return new Flag();
    }

    public Flag withName(String name) {
        this.name = name;
        return this;
    }
}
