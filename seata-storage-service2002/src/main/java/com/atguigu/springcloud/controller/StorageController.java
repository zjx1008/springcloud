package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjx
 * @create 2020-05-25-15:17
 */


@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("porductId") Long productId, @RequestParam("count") Integer count) {

        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }

}
