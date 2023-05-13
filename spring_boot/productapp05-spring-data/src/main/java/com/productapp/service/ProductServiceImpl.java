package com.productapp.service;

import com.productapp.entities.Product;
import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

   private ProductRepo productRepo;

   @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAll() {
       return productRepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        productRepo.save(product);
//        if(1==1)
//            throw new RuntimeException("some problem");
        return  product;
    }

    @Override
    public Product updateProduct(int productId, Product product) {
       Product productToUpdate=getById(productId);
       productToUpdate.setPrice(product.getPrice());
       productRepo.save(productToUpdate);
       return  productToUpdate;
    }

    @Override
    public Product getById(int productId) {
       return productRepo.findById(productId)
               .orElseThrow(() -> new ProductNotFoundException("product with id "+ productId+" is not found"));
    }

    @Override
    public Product deleteProduct(int productId) {
       Product productToDelete= getById(productId);
       productRepo.delete(productToDelete);
       return productToDelete;
    }
}
