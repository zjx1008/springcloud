package com.atguigu.springcloud.service;

/**
 * @author zjx
 * @create 2020-05-25-15:12
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
