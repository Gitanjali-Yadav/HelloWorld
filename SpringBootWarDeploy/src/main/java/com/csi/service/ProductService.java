package com.csi.service;

import com.csi.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Product save(Product product);

    public Optional<Product> findById(int prodId);

    public List<Product> findByProdName(String prodName);

    public List<Product> findAll();

    public Product update(Product product);

    public void deleteById(int prodId);

    public void deleteAll();
}
