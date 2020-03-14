package com.owlyowl.springcloud.controller;

import com.owlyowl.springcloud.entry.domain.PaymentDO;
import com.owlyowl.springcloud.entry.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Slf4j
@Api("下订单")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @SuppressWarnings("rawtypes")
    @ApiOperation("插入")
    @PostMapping("/")
    public CommonResult create(@RequestBody PaymentDO paymentDO) {
        return restTemplate.postForObject(PAYMENT_URL+"/payment/",paymentDO,CommonResult.class);
    }

    @SuppressWarnings("rawtypes")
    @ApiOperation("查询")
    @GetMapping("/")
    public CommonResult getPayment(@RequestParam String id) {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/?id="+id,CommonResult.class);
    }
}
