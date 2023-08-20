/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.spring.InternTest.repository;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.huce.ltudm.spring.InternTest.entity.ProductPrice;
import vn.edu.huce.ltudm.spring.InternTest.entity.Statistics;

/**
 *
 * @author vant
 */
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {

    @Modifying
    @Query(value = "UPDATE  Statistics s SET s.productPrice = :productPrice WHERE s.saleDate >= :date_end")
    void setProductPriceIdOnStatisticsAuto(@Param("productPrice") ProductPrice p, @Param("date_end") Date date_end);
}
