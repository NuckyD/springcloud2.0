package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String PaymentOk(Integer id){
        return "线程: "+Thread.currentThread().getName() +"方法：PaymentOk, 支付成功，id:" + id;
    }

    @HystrixCommand(fallbackMethod = "PaymentHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String PaymentTimeOut(Integer id){
        Integer time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int x = 10/0;
        return "线程: " + Thread.currentThread().getName() +"支付超时，PaymentTimeOut,id:" + id + "处理时间（秒）：" + time;
    }

    public String PaymentHandler(Integer id){
        return "线程: " + Thread.currentThread().getName() +
                "运行异常,id:" + id;
    }
}
