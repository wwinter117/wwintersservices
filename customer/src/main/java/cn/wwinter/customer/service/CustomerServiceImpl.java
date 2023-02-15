package cn.wwinter.customer.service;

import cn.wwinter.customer.repository.Customer;
import cn.wwinter.customer.repository.CustomerRegistrationRequest;
import cn.wwinter.customer.repository.CustomerRepository;
import cn.wwinter.customer.repository.FraudCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * CustomerServiceImpl
 * @Author zhangdongdong
 * @Date 2023/2/14
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestTemplate restTemplate;

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

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse checkResponse = restTemplate.getForObject(
                "http://FRAUD/fraud/api/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (checkResponse.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification

    }

    /**
     * 查看所有customer
     */
    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

}
