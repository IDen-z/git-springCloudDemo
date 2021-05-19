package com.zmz.springcloud.controller;

import com.zmz.springcloud.entity.CommenResult;
import com.zmz.springcloud.entity.Payment;
import com.zmz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/payment/create")
    public CommenResult create(Payment payment) {
        int res = paymentService.creat(payment);
        log.info("**********插入结果:" + res);

        if (res > 0) {
            return new CommenResult(000000, "操作数据库成功", res);

        } else {
            return new CommenResult(000001, "操作数据库失败", null);
        }


    }

    @GetMapping("/payment/get/{id}")
    public CommenResult getPaymentById(@PathVariable("id")  Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("**********查询结果:" + payment);

        if (payment !=null) {
            return new CommenResult(000000, "查询成功", payment);

        } else {
            return new CommenResult(000001, "没有对应记录，查询"+id+"失败", null);
        }


    }



}
