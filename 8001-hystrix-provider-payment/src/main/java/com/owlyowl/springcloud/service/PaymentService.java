package com.owlyowl.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String infoOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+"infoOk,id:"+id+"\t";
    }

    @HystrixCommand(fallbackMethod = "infoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String infoTimeOut(Integer id){
        int second = 5;
//        int second = 5/0;
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"infoTimeOut,id:"+id+"\t 耗时"+second+"秒";
    }

    public String infoTimeOutHandler(Integer id){
        return "8001线程池："+Thread.currentThread().getName()+"infoTimeOut,id:"+id+"\t 调用失败";

    }
}
