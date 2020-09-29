package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.spec.PSSParameterSpec;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentService.PaymentOk(id);
    }

    @GetMapping("/timeOut/{id}")
    public String timeOut(@PathVariable("id") Integer id){
        return paymentService.PaymentTimeOut(id);
    }
}
