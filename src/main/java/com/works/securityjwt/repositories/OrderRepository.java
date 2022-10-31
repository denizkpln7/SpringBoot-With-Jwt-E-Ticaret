package com.works.securityjwt.repositories;

import com.works.securityjwt.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByUidEquals(Long uid);
}
