package com.works.securityjwt.repositories;

import com.works.securityjwt.entities.OrderList;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList,Long> {


    @Query(value ="SELECT o.id as id, u.email as email, p.name as name ,p.text as text ,p.price as price FROM user u inner join orders o on u.id=o.uid inner join product p on o.pid=p.id" ,  nativeQuery = true)
    List<OrderList> orderList();

    @Query(value ="SELECT o.id as id, u.email as email, p.name as name ,p.text as text ,p.price as price FROM user u inner join orders o on u.id=o.uid inner join product p on o.pid=p.id Where u.id=?1" ,  nativeQuery = true)
    List<OrderList> orderListById(Long id);
}
