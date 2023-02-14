package cn.wwinter.customer.service;

import cn.wwinter.customer.repository.Customer;
import cn.wwinter.customer.repository.CustomerRegistrationRequest;
import cn.wwinter.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhangdongdong
 * @Date 2023/2/14
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * 注册
     */
    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();

        // todo: some checks

        customerRepository.save(customer);
    }

    /**
     * 查看所有customer
     */
    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

}
