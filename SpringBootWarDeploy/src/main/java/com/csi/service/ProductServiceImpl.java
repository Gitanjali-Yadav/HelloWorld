package com.csi.service;

import com.csi.entity.Product;
import com.csi.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    @Cacheable(value = "prodId")
    public Optional<Product> findById(int prodId) {
        log.info("@@@@@@@@TRYING TO FETCH DATA########");
        return productRepo.findById(prodId);
    }

    @Override
    public List<Product> findByProdName(String prodName) {
        return productRepo.findByProdName(prodName);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteById(int prodId) {
        productRepo.deleteById(prodId);
    }

    @Override
    public void deleteAll() {
        productRepo.deleteAll();
    }
}
