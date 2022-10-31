package com.works.securityjwt.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CateProduct {

    @Id
    private Long id;

    private String cad;

    private String pname;

    private  String image;

    private  String text;

    private  int price;

}
