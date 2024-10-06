package com.product.ProductMonolithic.controller;

import com.product.ProductMonolithic.entity.Product;
import com.product.ProductMonolithic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService prodService;

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Product> getAllProducts(){
        return prodService.getAllProducts();
    }
    @GetMapping("/products/{prodId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Product getAProduct(@PathVariable long prodId){
        return prodService.getAProduct(prodId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return prodService.addProduct(product);
    }
}
