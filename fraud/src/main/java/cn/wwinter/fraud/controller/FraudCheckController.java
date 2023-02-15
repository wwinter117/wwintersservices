package cn.wwinter.fraud.controller;

import cn.wwinter.fraud.repository.FraudCheckResponse;
import cn.wwinter.fraud.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FraudCheckController
 * @Author zhangdongdong
 * @Date 2023/2/15
 */
@RestController
@RequestMapping("fraud/api")
@Slf4j
public class FraudCheckController {
    @Autowired
    private FraudCheckService fraudCheckService;
    
    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check for customer {}", customerId);
        return FraudCheckResponse.builder()
                .isFraudster(isFraudulentCustomer)
                .build();
    }
}
