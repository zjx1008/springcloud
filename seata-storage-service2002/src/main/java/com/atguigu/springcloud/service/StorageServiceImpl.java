package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjx
 * @create 2020-05-25-15:13
 */
@Service

@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("扣库存开始===========》，productId="+productId+"\t  count="+count);
        storageDao.decrease(productId, count);
        log.info("扣除库存结束=============================");
    }


}
