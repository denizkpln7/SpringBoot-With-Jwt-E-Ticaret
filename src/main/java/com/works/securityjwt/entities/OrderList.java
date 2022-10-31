package com.works.securityjwt.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class OrderList {

    @Id
    private Long id;

    private String email;

    private String name;

    private  String text;

    private  int price;

}
