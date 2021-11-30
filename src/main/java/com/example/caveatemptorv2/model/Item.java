package com.example.caveatemptorv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal initialPrice;

    @NotNull
    private Date auctionEnd;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne
    private Category belongedCategory;

    @ManyToOne
    private User seller;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "belongedItem", cascade = CascadeType.REMOVE)
    List<Bid> bids;

    public Item(String name, BigDecimal initialPrice, Date auctionEnd, List<Image> images, Category belongedCategory, User seller) {
        this.name = name;
        this.initialPrice = initialPrice;
        this.auctionEnd = auctionEnd;
        this.images = images;
        this.belongedCategory = belongedCategory;
        this.seller = seller;
    }
}
