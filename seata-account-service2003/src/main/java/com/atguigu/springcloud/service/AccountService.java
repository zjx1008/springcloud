package com.atguigu.springcloud.service;

import java.math.BigDecimal;

/**
 * @author zjx
 * @create 2020-05-25-15:41
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
