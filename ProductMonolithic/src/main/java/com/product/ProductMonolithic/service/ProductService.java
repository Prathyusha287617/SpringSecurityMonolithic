package com.product.ProductMonolithic.service;

import com.product.ProductMonolithic.entity.Product;
import com.product.ProductMonolithic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository prodRepo;

    public List<Product> getAllProducts(){
        return prodRepo.findAll();
    }

    public Product getAProduct(long prodId){
        return prodRepo.findById(prodId).get();
    }

    public Product addProduct(Product product){
        return prodRepo.saveAndFlush(product);
    }
}
