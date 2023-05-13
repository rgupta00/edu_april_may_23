package com.productapp.controller;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController//@RestController=@Controller+ @ResponseBody
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //-----------get all---------
    //I want to control the http status code :
    //ResponseEniity = data + status code

    @GetMapping(path = "products")
    public ResponseEntity<List<Product>> getAll(){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }
    //-----------get by id---------
    @GetMapping(path = "products/{productId}")
    public Product getById(@PathVariable(name = "productId") int productId){
        return  productService.getById(productId);
    }


    @DeleteMapping(path = "products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "productId") int productId){
          productService.deleteProduct(productId);
          return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(path = "products")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product){
       return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }

    @PutMapping(path = "products/{productId}")
    public Product updateProduct(@PathVariable(name = "productId") int productId,@RequestBody Product product){
     return   productService.updateProduct(productId, product);
    }

}
