package com.website.argo.dto;

import com.website.argo.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String brandName;
    private String itemNumber;
    private byte[] mainImage;
    private String supplementFacts;
    private Long score;
    private String shortDescription;
    private String fullDescription;
    private String quantity;
    private List<CategoryDto> categoryDtoList;
}
