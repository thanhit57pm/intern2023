/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.spring.InternTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.huce.ltudm.spring.InternTest.entity.ProductPrice;

/**
 *
 * @author vant
 */
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {
    
}
