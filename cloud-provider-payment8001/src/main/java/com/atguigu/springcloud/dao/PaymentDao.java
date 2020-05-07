package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zjx
 * @create 2020-04-27-18:28
 */

@Mapper
@Repository
public interface PaymentDao {

    public int createPayment(Payment payment);

    public Payment getById(@Param("id") Long id);
}
