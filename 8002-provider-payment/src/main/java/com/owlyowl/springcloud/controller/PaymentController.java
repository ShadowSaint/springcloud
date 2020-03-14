package com.owlyowl.springcloud.controller;

import com.owlyowl.springcloud.entry.domain.PaymentDO;
import com.owlyowl.springcloud.entry.vo.CommonResult;
import com.owlyowl.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
@Api("支付")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;


    @ApiOperation("插入")
    @PostMapping("/")
    public CommonResult<PaymentDO> save(@RequestBody PaymentDO payment) {
        boolean result = paymentService.save(payment);
        log.info("****插入结果：" + result);

        if (result) {
            return new CommonResult<>(200, serverPort, payment);
        } else {
            return new CommonResult<>(444, serverPort, payment);
        }
//        return new CommonResult(444, "error", payment);
    }

    @ApiOperation("查询")
    @GetMapping("/")
    public CommonResult<PaymentDO> get(@RequestParam int id) {
        PaymentDO payment = paymentService.getById(id);
        if (payment != null) {
            return new CommonResult<>(200, serverPort, payment);
        } else {
            return new CommonResult<>(444, serverPort, null);
        }
//        return new CommonResult(444, "error", null);
    }

    @ApiOperation("服务发现")
    @GetMapping("/discovery")
    public Object discovery() {
        discoveryClient.getServices().forEach(log::info);
        discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE")
                .forEach(i->log.info(i.getServiceId()+"\t"+i.getHost()+"\t"+i.getPort()+"\t"+i.getUri()));
        return this.discoveryClient;
    }
}
