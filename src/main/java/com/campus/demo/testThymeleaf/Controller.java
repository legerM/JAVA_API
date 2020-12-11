/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.campus.demo.testThymeleaf;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IDAO dao ;

    

    @GetMapping("/Cars")
    public List<Car> getListCars() {
    
        return dao.findAll();
    }

    @GetMapping(value= "/Cars/{ID}")
    public Car getCarsByID(@PathVariable Integer ID) {
        Car car = dao.getOne(ID);
        return car;
    }
    
    @PostMapping(value ="/Cars", consumes ="application/json")
    public void addCar(@RequestBody Car newCar){
        
        dao.save(newCar);
    }

    @DeleteMapping(value = "/Cars/{ID}")
    public void deleteCar(@PathVariable Integer ID){
        dao.deleteById(ID);
    }
    
    @PutMapping(value = "/Cars/{ID}", consumes ="application/json")
    public void modifyCar(@RequestBody Car newCar , @PathVariable Integer ID){
        dao.save(newCar);
    }
}
