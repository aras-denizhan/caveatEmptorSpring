package com.example.caveatemptorv2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryDto {
    private String name;
    private String parentCategoryName;

    public SubCategoryDto(String name, String parentCategoryName) {
        this.name = name;
        this.parentCategoryName = parentCategoryName;
    }
}
