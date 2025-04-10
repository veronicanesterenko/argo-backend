package com.website.argo.dto;

import com.website.argo.entity.Product;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class BrandDto {
    private Long id;
    private String name;
    private String city;
}
