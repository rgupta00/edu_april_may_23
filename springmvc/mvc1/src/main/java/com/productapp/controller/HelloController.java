package com.productapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping(path = "hellourl")
    public String hello(Model model){
        model.addAttribute("message","i love teaching!");
        return "showall";
    }

    @GetMapping(path = "hellourl2")
    public String hello2(ModelMap modelMap){
        modelMap.addAttribute("message","i love teaching!");
        return "showall";
    }

//    @GetMapping(path = "hellourl")
//    public ModelAndView hello(ModelAndView mv){
//        mv.setViewName("showall");
//        mv.addObject("message","i love teaching!");
//        return mv;
//    }
}
