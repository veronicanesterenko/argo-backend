package com.website.argo.service.implementation;

import com.website.argo.dto.BrandCreateEditDto;
import com.website.argo.dto.BrandDto;
import com.website.argo.entity.Brand;
import com.website.argo.mapper.BrandMapper;
import com.website.argo.repository.BrandRepository;
import com.website.argo.service.BrandService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public BrandDto findById(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand with id = " + id + " not found"));
        return brandMapper.toBrandDto(brand);
    }

    @Override
    @Transactional
    public void save(BrandCreateEditDto brandCreateEditDto) {
        Brand brand = brandMapper.toBrand(brandCreateEditDto);
        brandRepository.save(brand);
    }

    @Override
    @Transactional
    public void update(Long id) {
        Brand updatedBrand = brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand with id = " + id + " not found"));
    }

    @Override
    @Transactional
    public void delete(Long brandId) {
        Brand deletedBrand = brandRepository.findById(brandId)
                .orElseThrow(() -> new EntityNotFoundException("Brand with id = " + brandId + " not found"));
        brandRepository.delete(deletedBrand);
    }
}
