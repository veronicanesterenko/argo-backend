package com.website.argo.dto;

import lombok.Data;

@Data
public class BrandCreateEditDto {
    private String name;
    private String city;
    private byte[] brandLogo;
    private String brandInfo;

}
