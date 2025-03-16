package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

@Data
public class Card {
    private Long id;
    private String type;
    private String number;
    private String name;
    private String securityCode;
    private String flag;
    private Boolean main;

    private Card() {}

    public static Card Create() {
        return new Card();
    }

    public Card withId(Long id) {
        this.id = id;
        return this;
    }

    public Card withType(String type) {
        this.type = type;
        return this;
    }

    public Card withNumber(String number) {
        this.number = number;
        return this;
    }

    public Card withName(String name) {
        this.name = name;
        return this;
    }

    public Card withSecurityCode(String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    public Card withFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public Card withMain(Boolean main) {
        this.main = main;
        return this;
    }
}
