package com.website.argo.dto;

import com.website.argo.entity.Brand;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;


@Data
@Builder
public class ProductCreatedEditDto {
    private String name;
    private Long brandId;
    private String itemNumber;
    private byte[] mainImage;
    private String supplementFacts;
    private Long score;
    private String shortDescription;
    private String fullDescription;
    private List<String> categories;
    private String quantity;
}
