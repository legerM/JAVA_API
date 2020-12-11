/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.campus.demo.testThymeleaf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mickael_L
 */
@Repository
public interface IDAO extends JpaRepository<Car, Integer> {
//    Car FindById(int id);
}
