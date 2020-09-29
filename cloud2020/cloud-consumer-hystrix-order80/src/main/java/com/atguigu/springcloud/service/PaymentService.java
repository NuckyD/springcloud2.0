package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentService {
    @GetMapping("/payment/ok/{id}")
    String ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeOut/{id}")
    String timeOut(@PathVariable("id") Integer id);
}
