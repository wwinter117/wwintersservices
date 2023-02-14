package cn.wwinter.customer.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhangdongdong
 * @Date 2023/2/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationRequest {
    private String name;
    private String email;
}
