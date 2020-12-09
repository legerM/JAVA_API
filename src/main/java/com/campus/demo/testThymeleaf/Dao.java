package com.campus.demo.testThymeleaf;


import com.campus.demo.testThymeleaf.car;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mickael_L
 */
public class Dao {
 HashMap<Integer, car> ListCars = new HashMap<Integer, car>();
    public Dao() {

    }

    public HashMap<Integer, car>  getListCars() {
       
        car mustang = new car(1, "mustang", "noire", "Ford");
        car clio = new car(2, "clio", "grise", "Renault");
        car twingo = new car(3, "Twingo", "verte", "Renault");

        ListCars.put(1, mustang);
        ListCars.put(2, clio);
        ListCars.put(3, twingo);
        return ListCars;
    }
    public void addCar(car car){
        
        ListCars.put(car.getID(), car);
    }
    
    public void deleteCar(Integer ID){
        ListCars.remove(ID);
    }
    
    public void modifyCar(car newCar){
        
        ListCars.remove(newCar.getID());
        ListCars.put(newCar.getID(), newCar);
    }
}
