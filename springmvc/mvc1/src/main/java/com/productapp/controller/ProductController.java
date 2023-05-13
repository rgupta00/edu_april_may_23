package com.productapp.controller;

import com.productapp.model.entities.Product;
import com.productapp.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Controller
public class ProductController {

    private ProductService productService;

    @PostConstruct
    public void init(){
//        productService.addProduct(new Product("TV", new BigDecimal(78000)));
//        productService.addProduct(new Product("Dell Laptop", new BigDecimal(100000)));
    }
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //------------Show all products
    @GetMapping
    public String home(){
        return "redirect:showall";
    }
    @GetMapping(path = "showall")
    public ModelAndView showAll(ModelAndView mv){
        mv.setViewName("showall");
        mv.addObject("productList", productService.getAll());
        return  mv;
    }

    //-----------for post a new product ------------
    //used to bind the object with the form (jsp)
    @GetMapping(path = "addproduct")
    public String addProductGet(ModelMap modelMap){
        Product product=new Product();//no data
        modelMap.addAttribute("product", product);
        return  "addproduct";
    }

    @PostMapping(path = "addproduct")
    public String addProductPost(@ModelAttribute(value = "product") Product product){
        Integer id=product.getId();
        if(id==0) {
            productService.addProduct(product);
        }else {
            productService.updateProduct(id, product);
        }
        return  "redirect:showall";    //PRG design pattern, double form submission problem ?
    }

    //----------delete a product -----?id=-------
    @GetMapping(path = "delete")
    public String deleteProduct(@RequestParam(name = "id") int id){
       productService.deleteProduct(id);
        return  "redirect:showall";
    }
    //---------update 2 method
    @GetMapping(path = "update")
    public String updateProductGet(@RequestParam(name = "id") int id, ModelMap modelMap){
        Product product=productService.getById(id);
        modelMap.addAttribute("product", product);
        return  "updateproduct";
    }
}
