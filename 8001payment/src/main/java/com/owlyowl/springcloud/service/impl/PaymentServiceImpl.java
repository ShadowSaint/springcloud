package com.owlyowl.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.owlyowl.springcloud.entry.domain.PaymentDO;
import com.owlyowl.springcloud.mapper.PaymentMapper;
import com.owlyowl.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, PaymentDO> implements PaymentService {
}
