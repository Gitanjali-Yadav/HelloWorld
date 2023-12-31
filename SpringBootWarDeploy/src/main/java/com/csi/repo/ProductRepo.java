package com.csi.repo;

import com.csi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    //custom methods goes here

    public List<Product> findByProdName(String prodName);

}
