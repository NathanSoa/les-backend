package br.com.nathan.ecommerce.main.modules.customer.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static br.com.nathan.ecommerce.main.core.utils.Utils.TrueIfNull;

@Data
public class Customer {

    private Long id;
    private Name name;
    private Email email;
    private CPF cpf;
    private Phone phone;
    private Password password;
    private List<Address> address;
    private List<Card> card;
    private Boolean active;

    private Customer() {
        this.address = new ArrayList<>();
        this.card = new ArrayList<>();
    }

    public static Customer Create() {
        return new Customer();
    }

    public Customer withId(Long id) {
        this.id = id;
        return this;
    }

    public Customer withName(String name) {
        this.name = Name.Create(name);
        return this;
    }

    public Customer withEmail(String email) {
        this.email = Email.Create(email);
        return this;
    }

    public Customer withCPF(String cpf) {
        this.cpf = CPF.Create(cpf);
        return this;
    }

    public Customer withPhone(String phone) {
        this.phone = Phone.Create(phone);
        return this;
    }

    public Customer withPassword(String password) {
        this.password = Password.Create(password);
        return this;
    }

    public Customer withAddress(List<Address> address) {
        if(address == null || address.isEmpty()) throw new IllegalArgumentException("address.required");
        this.address = address.stream()
                .map(a -> Address.Create()
                        .withAlias(a.getAlias())
                        .withCity(a.getCity())
                        .withComplement(a.getComplement())
                        .withNeighborhood(a.getNeighborhood())
                        .withNumber(a.getNumber())
                        .withStreetPurpose(a.getStreetPurpose())
                        .withState(a.getState())
                        .withStreet(a.getStreet())
                        .withZipCode(a.getZipCode())
                )
                .toList();
        return this;
    }

    public Customer withCard(List<Card> cards) {
        if(cards == null || cards.isEmpty()) throw new IllegalArgumentException("card.required");
        this.card = cards.stream()
                .map(c -> Card.Create()
                        .withType(c.getType())
                        .withNumber(c.getNumber())
                        .withName(c.getName())
                        .withSecurityCode(c.getSecurityCode())
                        .withFlag(c.getFlag())
                        .withMain(c.getMain())
                )
                .toList();
        return this;
    }

    public Customer withActive(Boolean active) {
        this.active = active;
        return this;
    }
}
