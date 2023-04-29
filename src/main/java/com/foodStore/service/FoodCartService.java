package com.foodStore.service;

import com.foodStore.entity.FoodCart;
import com.foodStore.repository.FoodCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCartService {
    @Autowired private FoodCartRepository foodCart;
    public void saveFoodCart(FoodCart food) {
       foodCart.save(food);
    }
    public List<FoodCart> getAllFoodstuffs(){
        return foodCart.findAll();
    }
    public void deleteById(int id){
       foodCart.deleteById(id);
    }
}
