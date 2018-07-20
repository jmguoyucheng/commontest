package com.yucn.controller;

import com.yucn.entity.Customer;
import com.yucn.repository.CustomerRepository;
import com.yucn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/6/14.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @GetMapping
    @ResponseBody
    public Customer find(){
        Customer customer=customerRepository.findFirstById("8a8b23b363fd4fd80163fd4fe5060000");
        return customer;
    }

    @PostMapping
    @RequestMapping("/modify")
    public void modify(){
        customerService.update();
    }

    @PostMapping
    @RequestMapping("/remove")
    public void remove(){
        customerService.remove();
    }
}
