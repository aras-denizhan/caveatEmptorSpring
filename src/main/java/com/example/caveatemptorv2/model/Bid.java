package com.example.caveatemptorv2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Date createdOn;

    @ManyToOne
    private User bidder;

    @ManyToOne
    private Item belongedItem;

    public Bid(BigDecimal amount, Date createdOn, User bidder, Item belongedItem) {
        this.amount = amount;
        this.createdOn = createdOn;
        this.bidder = bidder;
        this.belongedItem = belongedItem;
    }
}
