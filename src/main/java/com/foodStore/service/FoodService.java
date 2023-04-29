package com.foodStore.service;

import com.foodStore.entity.Food;
import com.foodStore.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired private FoodRepository fRepo;
    public void save(Food f){
        fRepo.save(f);
    }
    public List<Food> getAllFood(){
        return fRepo.findAll();
    }
    public Food getFoodById(int id){
        return fRepo.findById(id).get();
    }
    public void deleteById(int id){
        fRepo.deleteById(id);
    }
}
