package springcloud.service;

import com.owlyowl.springcloud.entry.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import springcloud.entry.domain.PaymentDO;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @PostMapping("/payment/")
    public CommonResult<PaymentDO> save(PaymentDO payment);

    @GetMapping("/payment/")
    public CommonResult<PaymentDO> get(int id);

}
