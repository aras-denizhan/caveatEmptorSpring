package com.example.caveatemptorv2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @OneToMany(mappedBy = "bidder", orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Bid> bids;

    @OneToMany(mappedBy = "seller", orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Item> soldItems;

    @OneToOne(cascade=CascadeType.ALL)
    private Address homeAddress;

    @OneToOne(cascade=CascadeType.ALL)
    private Address billingAddress;

    @OneToOne(cascade=CascadeType.ALL)
    private Address shippingAddress;
}
