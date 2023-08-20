/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.spring.InternTest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.huce.ltudm.spring.InternTest.entity.ProductPrice;
import vn.edu.huce.ltudm.spring.InternTest.repository.ProductPriceRepository;

/**
 *
 * @author vant
 */
@Service
@Transactional
public class ProductPriceService {

    @Autowired
    ProductPriceRepository productPriceRepo;

    public List<ProductPrice> getAll() {
        return productPriceRepo.findAll();
    }

    public ProductPrice getProductPriceById(int id) {
        return productPriceRepo.findById(id).get();
    }
}
