package com.owlyowl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.owlyowl.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Slf4j
@Api("下订单")
@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @ApiOperation("成功")
    @GetMapping("/ok")
    @HystrixCommand(fallbackMethod = "infoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String ok(@RequestParam("id") Integer id) {
        String result = paymentFeignService.ok(id);
        return result;
    }

    @ApiOperation("超时")
    @GetMapping("/timeout")
    @HystrixCommand
    public String timeout(@RequestParam("id") Integer id) {
        String result = paymentFeignService.timeout(id);
        return result;
    }
    public String infoTimeOutHandler(Integer id){
        return "80线程池："+Thread.currentThread().getName()+"infoTimeOut,id:"+id+"\t 调用失败";
    }

    public String globalFallBack(){
        return "80出异常了";
    }
}
