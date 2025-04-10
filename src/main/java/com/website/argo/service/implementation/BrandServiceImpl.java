package com.website.argo.service.implementation;

import com.website.argo.entity.Brand;
import com.website.argo.repository.BrandRepository;
import com.website.argo.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
