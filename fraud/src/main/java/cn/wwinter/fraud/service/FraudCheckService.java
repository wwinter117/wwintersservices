package cn.wwinter.fraud.service;

import cn.wwinter.fraud.repository.FraudCheckHistory;
import cn.wwinter.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * FraudCheckService
 * @Author zhangdongdong
 * @Date 2023/2/15
 */
@Service
public class FraudCheckService {
    @Autowired
    private FraudCheckHistoryRepository fraudCheckHistoryRepository;

    /**
     * isFraudulentCustomer
     */
    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
