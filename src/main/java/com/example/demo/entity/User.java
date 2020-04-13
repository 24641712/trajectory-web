package com.example.demo.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String uid;

    private String name;

    private String sex;

    private String age;

    private String interests;

    public User() {
    }

}
