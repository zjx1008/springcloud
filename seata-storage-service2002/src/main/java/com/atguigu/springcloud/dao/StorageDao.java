package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zjx
 * @create 2020-05-25-15:11
 */


@Mapper
@Repository(value = "StorageDao")
public interface StorageDao {

    void  decrease (@Param("productId") Long productId,@Param("count") Integer count);
}
