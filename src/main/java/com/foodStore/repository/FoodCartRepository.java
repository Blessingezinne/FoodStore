package com.foodStore.repository;

import com.foodStore.entity.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart,Integer> {
}
