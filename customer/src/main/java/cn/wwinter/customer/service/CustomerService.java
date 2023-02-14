package cn.wwinter.customer.service;

import cn.wwinter.customer.repository.Customer;
import cn.wwinter.customer.repository.CustomerRegistrationRequest;

import java.util.List;

public interface CustomerService {

    /**
     * 注册
     */
    void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);

    /**
     * 查看所有customer
     */
    List<Customer> findAllCustomers();

}
