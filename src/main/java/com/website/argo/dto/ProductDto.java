package com.website.argo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDto {
    private String name;
    private String brand;
    private String itemNumber;
    private byte[] mainImage;
    private String supplementsFacts;
    private Long score;
    private String shortDescription;
    private String fullDescription;
    private List<String> categories;
}
