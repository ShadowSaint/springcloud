package com.owlyowl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentFeignService {

    @GetMapping("/payment/hystrix/ok")
    public String ok(@RequestParam("id") Integer id);

    @GetMapping("/payment/hystrix/timeout")
    public String timeout(@RequestParam("id") Integer id);

}
