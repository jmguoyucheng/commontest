package com.yucn.repository;

import com.yucn.entity.Customer;
import com.yucn.entity.SaleStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/6/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleStrategyRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SaleStrategyRepository saleStrategyRepository;

    @Test
    public void saveTest(){
        SaleStrategy saleStrategy=new SaleStrategy();
        saleStrategy.setTitle("s1");
        Customer customer=customerRepository.findFirstById("8a8b23b363fd4fd80163fd4fe5060000");
        //saleStrategy.setCustomer(customer);
        saleStrategyRepository.save(saleStrategy);
    }

}