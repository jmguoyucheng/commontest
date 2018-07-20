package com.yucn.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2018/7/7.
 */
@Data
public class User {
    private Long id;
    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
