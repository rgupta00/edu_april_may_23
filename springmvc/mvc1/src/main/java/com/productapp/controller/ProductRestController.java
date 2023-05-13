package com.productapp.controller;

import com.productapp.model.entities.Product;
import com.productapp.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;
//api/products
/*

    @ResponseBody: this convert java object to json
    @RequestBody: this convert json to java object : supported by the json parser
 */
@RestController //@RestController=@Controller+@ResponseBody(trigger the parser to conver ur java object to json)  vs @Controller
@RequestMapping(path = "api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }
    //-------get all the products-------------
    @GetMapping(path = "products")
    public List<Product> getAll(){
        return  productService.getAll();
    }

    //-------get all the products-----when product is added to db the status code must be 201 (M to M communication)--------
    //how to customized the http status code? use correct status code? ResponseEntitity
    @GetMapping(path = "products/{id}")
    public Product getById(@PathVariable(name = "id") int id){
        return  productService.getById(id);
    }

    //------add new the product------------
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return  ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }

    //------update the product------------
    @PutMapping(path = "products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "id") int id,
                                 @RequestBody    Product product){
        return  ResponseEntity.status(HttpStatus.OK)
                .body(productService.updateProduct(id, product));
    }
    //-------delete a product-------------
    @DeleteMapping(path = "products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") int id){
          productService.deleteProduct(id);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
