/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.spring.InternTest.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.huce.ltudm.spring.InternTest.entity.ProductPrice;
import vn.edu.huce.ltudm.spring.InternTest.entity.Statistics;
import vn.edu.huce.ltudm.spring.InternTest.repository.ProductPriceRepository;
import vn.edu.huce.ltudm.spring.InternTest.repository.StatisticsRepository;

/**
 *
 * @author vant
 */
@Service
@Transactional
public class StatisticsService {

    @Autowired
    StatisticsRepository statisticsRepo;

    @Autowired
    ProductService productService;

    public Statistics getStatisticsById(int id) {
        return statisticsRepo.findById(id).get();
    }

    public List<Statistics> getAll() {
        return statisticsRepo.findAll();
    }

    public void setProductPriceIdOnStatisticsAuto(ProductPrice p, Date date_end) {
        statisticsRepo.setProductPriceIdOnStatisticsAuto(p, date_end);
    }

    public int getInterestDay(int id) {
        int priceOfRiceGood = this.getStatisticsById(id).getProductPrice().getPrice();
        int priceByBad = productService.getProductById(2).getPrice();

        int qty = this.getStatisticsById(id).getQty();

        return (priceOfRiceGood - priceByBad) * qty * 300 / 5000;
    }

    public int getInterestWeek(int week) {
        int interestWeek, i;

        int dayEnd = 7 * week > this.getAll().size() ? this.getAll().size() : 7 * week; // sô thu tu cua ngay

        for (interestWeek = 0, i = 7 * week - 6; i <= dayEnd; i++) {
            interestWeek += this.getInterestDay(i);
        }
        return interestWeek;
    }
}
