/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.campus.demo.testThymeleaf;

import java.util.HashMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 *
 * @author Mickael_L
 */
public class Controller {

//    HashMap<Integer, car> ListCars = new HashMap<Integer, car>();
    Dao dao = new Dao();

    

    @GetMapping("/Cars")
    public HashMap<Integer, car> getListCars() {
        return dao.getListCars();
    }

    @GetMapping(value= "/Cars/{ID}")
    public car getCarsByID(@PathVariable Integer ID) {
        car car = dao.getListCars().get(ID);
        return car;
    }
    
    @PostMapping(value ="/Cars", consumes ="application/json")
    public void addCar(@RequestBody car newCar){
        dao.addCar(newCar);
    }

    @DeleteMapping(value = "/Cars/{ID}")
    public void deleteCar(@PathVariable Integer ID){
        dao.deleteCar(ID);
    }
    
    @PutMapping(value = "/Cars/{ID}", consumes ="application/json")
    public void modifyCar(@RequestBody car newCar , @PathVariable Integer ID){
        dao.modifyCar(newCar);
    }
}
