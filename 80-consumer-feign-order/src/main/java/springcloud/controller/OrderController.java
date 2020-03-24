package springcloud.controller;

import com.owlyowl.springcloud.entry.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springcloud.entry.domain.PaymentDO;
import springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Slf4j
@Api("下订单")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private PaymentFeignService paymentFeignService;

    @SuppressWarnings("rawtypes")
    @ApiOperation("插入")
    @PostMapping("/")
    public CommonResult<PaymentDO> create(@RequestBody PaymentDO paymentDO) {
        return paymentFeignService.save(paymentDO);
    }

    @SuppressWarnings("rawtypes")
    @ApiOperation("查询")
    @GetMapping("/")
    public CommonResult<PaymentDO> getPayment(@RequestParam int id) {
        return paymentFeignService.get(id);
    }
}
