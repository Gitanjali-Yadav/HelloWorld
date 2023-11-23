package com.csi.controller;

import com.csi.entity.Product;
import com.csi.exception.RecordNotFoundException;
import com.csi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productServiceImpl.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{prodId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable int prodId) {
        return ResponseEntity.ok(productServiceImpl.findById(prodId));
    }

    @GetMapping("/findByProdName/{prodName}")
    public ResponseEntity<List<Product>> findByProdName(@RequestParam String prodName) {
        return ResponseEntity.ok(productServiceImpl.findByProdName(prodName));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productServiceImpl.findAll());
    }

    @PutMapping("/update/{prodId}")
    public ResponseEntity<Product> update(@PathVariable int prodId, @RequestBody Product product) {

        Product product1 = productServiceImpl.findById(prodId).orElseThrow(() -> new RecordNotFoundException("ProdId does not Exist !!"));

        product1.setProdName(product.getProdName());
        product1.setProdPrice(product.getProdPrice());
        product1.setProdLaunchDate(product.getProdLaunchDate());

        return new ResponseEntity<>(productServiceImpl.update(product1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById/{prodId}")
    public ResponseEntity<String> deleteById(@PathVariable int prodId) {
        productServiceImpl.deleteById(prodId);
        return ResponseEntity.ok("Data Deleted Success !!");
    }

    @DeleteMapping("/delteAll")
    public ResponseEntity<String> deleteAll() {
        productServiceImpl.deleteAll();
        return ResponseEntity.ok("All Data Deleted Success !!");
    }
}
