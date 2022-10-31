package com.works.securityjwt.restcontrollers;


import com.works.securityjwt.entities.Orders;
import com.works.securityjwt.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    final OrderService oService;

    public OrderRestController(OrderService oService) {
        this.oService = oService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Orders order){
        return oService.save(order);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id){
        return  oService.delete(id);
    }

    @GetMapping("/getorder")
    public ResponseEntity getOrder(){
        return  oService.getOrder();
    }

    @GetMapping("/getorderby")
    public ResponseEntity getOrderBy(@RequestParam  Long id){

        return  oService.getOrdeBy(id);
    }
}
