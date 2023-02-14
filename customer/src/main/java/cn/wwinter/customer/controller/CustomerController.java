package cn.wwinter.customer.controller;

import cn.wwinter.customer.repository.Customer;
import cn.wwinter.customer.repository.CustomerRegistrationRequest;
import cn.wwinter.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * customer controller
 * @Author zhangdongdong
 * @Date 2023/2/14
 */
@Slf4j
@RestController
@RequestMapping("customer/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 注册
     */
    @PostMapping("register")
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    /**
     * 查看所有customer
     */
    @GetMapping("findAll")
    public List<Customer> findAll() {
        return customerService.findAllCustomers();
    }
}
