package com.owlyowl.springcloud.controller;

import com.owlyowl.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment/hystrix")
@Slf4j
@Api("支付")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @ApiOperation("成功")
    @GetMapping("/ok")
    public String ok(@RequestParam("id") Integer id) {
        String result = paymentService.infoOk(id);
        log.info("****result:" + result);
        return result;
    }

    @ApiOperation("超时")
    @GetMapping("/timeout")
    public String timeout(@RequestParam("id") Integer id) {
        String result = paymentService.infoTimeOut(id);
        log.info("****result:" + result);
        return result;
    }
}
