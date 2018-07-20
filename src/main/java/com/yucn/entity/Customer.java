package com.yucn.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
@Entity
@Data
public class Customer {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "customer")
    private List<SaleStrategy> saleStrategies;
}
