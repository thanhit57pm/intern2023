/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.spring.InternTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.huce.ltudm.spring.InternTest.entity.Product;

/**
 *
 * @author vant
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Modifying
    @Query(value = "UPDATE Product p SET p.price = :price WHERE p.id = 1")
    void UpdatePriceOfGoodRice(@Param("price") int price);
}
