package com.atguigu.springcloud.Dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;

/**
 * @author zjx
 * @create 2020-05-25-11:34
 */

@Mapper
public interface OrderDao {

    void create(Order order);
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
