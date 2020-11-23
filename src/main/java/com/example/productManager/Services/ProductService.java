package com.example.productManager.Services;

import com.example.productManager.Models.Product;
import com.example.productManager.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //automatically inject a instance of the repo
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public Product getSingleProduct(Long id){
        return productRepository.findById(id).get();
    }

    public void deleteSingleProduct(Long id){
        productRepository.deleteById(id);
    }
}
