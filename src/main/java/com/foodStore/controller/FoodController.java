package com.foodStore.controller;

import com.foodStore.entity.Food;
import com.foodStore.entity.FoodCart;
import com.foodStore.service.FoodCartService;
import com.foodStore.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class FoodController {

	@Autowired private FoodService service;
	@Autowired private FoodCartService foodCartService;
	@GetMapping("/")
	public String home() {
		return"home";
	}
	@GetMapping("/available_foodstuffs")
	public ModelAndView getAllFoodstuffs() {
		List<Food>list = service.getAllFood();
		/**ModelAndView m = new ModelAndView();
		m.setViewName("foodList");
		m.addObject("food", list);*/
		return new ModelAndView("foodList","food",list);

	}
	@GetMapping("/food_register")
	public String foodRegister(){
		return "foodRegister";
	}
	@GetMapping("/food_cart")
	public String getFoodCart(Model model){
		List<FoodCart> list = foodCartService.getAllFoodstuffs();
		model.addAttribute("food",list);
		return "foodCart";
	}
	@PostMapping("/save")
	public String addFood(@ModelAttribute Food f){
		service.save(f);
		return"redirect:/available_foodstuffs";
	}
	@RequestMapping("/foodCart/{id}")
	public String getFoodCart(@PathVariable("id") int id){
		Food f = service.getFoodById(id);
		FoodCart fc =new FoodCart(f.getId(),f.getName(),f.getType(),f.getPrice());
		foodCartService.saveFoodCart(fc);
		return "redirect:/food_cart";
	}
	@RequestMapping("/editFood/{id}")
	public String editFood(@PathVariable("id") int id, Model model){
		Food f = service.getFoodById(id);
		model.addAttribute("food", f);
		return"foodEdit";
	}
	@RequestMapping("/deleteFood/{id}")
	public String deleteFood(@PathVariable("id") int id){
		service.deleteById(id);
		return"redirect:/available_foodstuffs";
	}


}
