package com.works.securityjwt.services;

import com.works.securityjwt.entities.Orders;
import com.works.securityjwt.repositories.OrderListRepository;
import com.works.securityjwt.repositories.OrderRepository;
import com.works.securityjwt.repositories.ProductRepository;
import com.works.securityjwt.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class OrderService {

    final OrderRepository oRepo;
    final UserRepository uRepo;
    final ProductRepository pRepo;
    final OrderListRepository orListRepo;

    public OrderService(OrderRepository oRepo, UserRepository uRepo, ProductRepository pRepo, OrderListRepository orListRepo) {
        this.oRepo = oRepo;
        this.uRepo = uRepo;
        this.pRepo = pRepo;
        this.orListRepo = orListRepo;
    }


    public ResponseEntity save(Orders order) {
        Map<String, Object> hm = new LinkedHashMap<>();
        boolean isUser=uRepo.existsById(order.getUid());
        boolean isProduct=pRepo.existsById(order.getPid());
        if(isUser==true && isProduct==true){
            oRepo.save(order);
            hm.put("status", true);
            hm.put("result","ürün sepete eklendi" );
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        oRepo.deleteById(id);
        hm.put("status", true);
        hm.put("result","Başarıyla silindi" );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getOrder() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result",orListRepo.orderList() );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity getOrdeBy(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result",orListRepo.orderListById(id) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
