package com.foodStore.controller;

import com.foodStore.service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodCartController {
    @Autowired private FoodCartService service;
    @RequestMapping("/deleteFoodCart/{id}")
    public String deleteFoodCart(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/food_cart";
    }

}
