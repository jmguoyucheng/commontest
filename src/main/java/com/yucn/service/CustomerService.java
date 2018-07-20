package com.yucn.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yucn.entity.Customer;
import com.yucn.entity.SaleStrategy;
import com.yucn.repository.CustomerRepository;
import com.yucn.repository.SaleStrategyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/18.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SaleStrategyRepository saleStrategyRepository;
    @Autowired
    private EntityManager entityManager;
    @Transactional
    public void update(){
        Customer customer=customerRepository.findFirstById("8a8b23b3641d033a01641d03415c0000");
        SaleStrategy saleStrategy=new SaleStrategy();
        saleStrategy.setTitle("5");
        customer.getSaleStrategies().add(saleStrategy);

        List<SaleStrategy> saleStrategies =customer.getSaleStrategies();
        saleStrategies.forEach(item->{
            item.setCustomer(customer);
        });

        saleStrategyRepository.save(customer.getSaleStrategies());
    }

    @Transactional
    public void remove(){
        //Customer customer=customerRepository.findFirstById("8a8b23b3641000900164100097500000");

        SaleStrategy saleStrategy=saleStrategyRepository.findOne("8a8b23b3641000900164100097900002");

        //List<SaleStrategy> saleStrategies =customer.getSaleStrategies();
        //saleStrategies.remove(saleStrategy);
        //saleStrategyRepository.save(saleStrategies);
        saleStrategyRepository.delete(saleStrategy);
    }
}
