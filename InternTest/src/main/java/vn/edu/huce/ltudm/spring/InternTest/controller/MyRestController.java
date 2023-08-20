/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.spring.InternTest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.huce.ltudm.spring.InternTest.entity.ProductPrice;
import vn.edu.huce.ltudm.spring.InternTest.entity.Statistics;
import vn.edu.huce.ltudm.spring.InternTest.model.InterestDay;
import vn.edu.huce.ltudm.spring.InternTest.model.InterestWeek;
import vn.edu.huce.ltudm.spring.InternTest.service.ProductPriceService;
import vn.edu.huce.ltudm.spring.InternTest.service.ProductService;
import vn.edu.huce.ltudm.spring.InternTest.service.StatisticsService;

/**
 *
 * @author vant
 */
@RestController
public class MyRestController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductPriceService productPriceService;

    @Autowired
    StatisticsService statisticsService;

    //  Khi thêm 1 giá moi(tang gia) vao bang ProductPrice, can cu theo ngay 
    // them vao:
    // 1. Giá này đuoc cap nhat(giá moi nhat) vao bang Product. Gia gao xin o 
    // bang product chi de xem chu khong anh huong den thong ke (khong su dung de tinh toan)
    // 2. Bat đau tu ngày nay, gia moi se duoc ap dung, nguoi dung chi can nhap qty vào bang Statistics, giá này tu dong
    // ap dung (product_price_id tu dong setup) mà khong anh huong den thông ke voi gia cu truoc do
    @GetMapping("/")
    public ResponseEntity<String> setPriceOfGoodRiceOnProductAndProductPriceIdOnStatisticsAuto() {
        List<ProductPrice> listProductPrice = productPriceService.getAll();

        // 1.
        productService.setPriceOfGoodRiceAuto(listProductPrice.get(listProductPrice.size() - 1).getPrice());

        // 2.
        ProductPrice p = listProductPrice.get(listProductPrice.size() - 1);
        Date date_end = listProductPrice.get(listProductPrice.size() - 1).getCreatedAt();

        statisticsService.setProductPriceIdOnStatisticsAuto(p, date_end);

        return new ResponseEntity<>(null, HttpStatus.valueOf(204)); // neu cap nhat thanh cong, tra ve ma 204
    }

    // Xem tien lai tat ca cac ngay, xep theo thu tu giam dan
    @GetMapping("interest/day")
    public List<InterestDay> getInterestByDate() {
        List<InterestDay> listInterestDay = new ArrayList<>();
        List<Statistics> listStatistics = statisticsService.getAll();

        for (Statistics st : listStatistics) {
            InterestDay interestDay = new InterestDay();

            int interest = statisticsService.getInterestDay(st.getId());

            interestDay.setId(st.getId());
            interestDay.setInterest(interest);

            listInterestDay.add(interestDay);

            listInterestDay.sort((interestDay1, interestDay2) -> interestDay2.getInterest() - interestDay1.getInterest());
        }
        return listInterestDay;
    }

    // Xem tien lai tat ca cac tuan
    @GetMapping("interest/week")
    public List<InterestWeek> getInterestByWeek() {
        List<InterestWeek> listInterestWeek = new ArrayList();

        int numWeek = (int) Math.ceil(statisticsService.getAll().size() / 7.0);

        for (int i = 1; i <= numWeek; i++) {
            InterestWeek interestWeek = new InterestWeek();
            int interest = statisticsService.getInterestWeek(i);

            interestWeek.setWeek(i);
            interestWeek.setInterest(interest);

            listInterestWeek.add(interestWeek);
        }
        return listInterestWeek;
    }

    // Xem tien lai theo tuan duoc chi dinh
    @GetMapping("/week/{week}")
    public int getInterestOneWeek(@PathVariable Integer week) {
        return statisticsService.getInterestWeek(week);
    }
}
