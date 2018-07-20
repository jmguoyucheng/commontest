package com.yucn.repository;

import com.yucn.entity.Customer;
import com.yucn.entity.SaleStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/6/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SaleStrategyRepository saleStrategyRepository;

    @Test
    public void saveTest(){
        Customer customer=new Customer();
        customer.setName("a");
        customerRepository.save(customer);
    }

    @Test
    public void saveTest1(){
        Customer customer=new Customer();
        SaleStrategy saleStrategy=new SaleStrategy();
        saleStrategy.setTitle("1");
        SaleStrategy saleStrategy1=new SaleStrategy();
        saleStrategy1.setTitle("2");
        List<SaleStrategy> saleStrategies=new ArrayList<>();
        saleStrategies.add(saleStrategy);
        saleStrategies.add(saleStrategy1);
        customer.setName("a");
        customer.setSaleStrategies(saleStrategies);

        customerRepository.save(customer);
        List<SaleStrategy> list=customer.getSaleStrategies();
        list.forEach(item->{
            item.setCustomer(customer);
        });
        saleStrategyRepository.save(list);
    }

    @Test
    @Transactional
    public void updateTest(){
        Customer customer=customerRepository.findFirstById("8a8b23b3641d033a01641d03415c0000");
        SaleStrategy saleStrategy=new SaleStrategy();
        saleStrategy.setTitle("4");
        customer.getSaleStrategies().add(saleStrategy);

        List<SaleStrategy> saleStrategies =customer.getSaleStrategies();
        saleStrategies.forEach(item->{
            item.setCustomer(customer);
        });

        customerRepository.save(customer);
    }

    @Test
    @Transactional
    public void findTest(){
        Customer customer=customerRepository.findFirstById("8a8b23b363fd4fd80163fd4fe5060000");
        System.out.println(customer.getSaleStrategies().size());
    }

    @Test
    @Transactional
    public void optionalTest(){
        System.out.println("part1=====================");
        Optional<String> name1=Optional.ofNullable("yucn");
        name1.ifPresent(System.out::println);
        System.out.println("part2=====================");
        Optional<String> name2=Optional.ofNullable(null);
        name2.ifPresent(System.out::println);
        System.out.println("part3=====================");
        Optional<Customer> customer=Optional.ofNullable(customerRepository.findFirstById("8a8b23b3641d033a01641d03415c0000"));
        List<SaleStrategy> saleStrategies=customer.map(c -> c.getSaleStrategies()).orElse(Collections.emptyList());
        System.out.println(saleStrategies.size());
    }
}