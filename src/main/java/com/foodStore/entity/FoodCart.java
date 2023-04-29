package com.foodStore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FoodCartList")
public class FoodCart {
    @Id
    private int id;
    private String name;
    private String type;
    private String price;
    public FoodCart(int id, String name, String type, String price) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public FoodCart() {
        super();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
