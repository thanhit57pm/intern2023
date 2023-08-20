/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.spring.InternTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.huce.ltudm.spring.InternTest.entity.Product;
import vn.edu.huce.ltudm.spring.InternTest.repository.ProductRepository;

/**
 *
 * @author vant
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepo;

    public Product getProductById(int id) {
        return productRepo.findById(id).get();
    }

    public void setPriceOfGoodRiceAuto(int price) {
        productRepo.UpdatePriceOfGoodRice(price);
    }
}
