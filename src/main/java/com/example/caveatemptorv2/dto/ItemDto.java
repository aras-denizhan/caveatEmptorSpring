package com.example.caveatemptorv2.dto;

import com.example.caveatemptorv2.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ItemDto {
    private String name;
    private BigDecimal initialPrice;
    private Date auctionEnd;
    private List<Image> images;
    private String categoryName;
    private String sellerName;

    public ItemDto(String name, BigDecimal initialPrice, Date auctionEnd, List<Image> images, String categoryName, String sellerName) {
        this.name = name;
        this.initialPrice = initialPrice;
        this.auctionEnd = auctionEnd;
        this.images = images;
        this.categoryName = categoryName;
        this.sellerName = sellerName;
    }
}
