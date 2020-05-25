package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.Dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zjx
 * @create 2020-05-25-11:48
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;


    @Override

    @GlobalTransactional
    public void create(Order order) {

        log.info("新建订单");
        orderDao.create(order);

        log.info("----------------------------》库存扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----------------------------》账户扣减扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------------------------>更改订单状态为0");
        orderDao.update(order.getUserId(),0);
        log.info("================================>订单状态修改成功");
    }
}
