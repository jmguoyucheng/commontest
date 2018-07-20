package com.yucn.repository;

import com.yucn.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/6/14.
 */
public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer findFirstById(String id);
}
