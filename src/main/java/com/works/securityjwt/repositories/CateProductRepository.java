package com.works.securityjwt.repositories;

import com.works.securityjwt.entities.CateProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CateProductRepository extends JpaRepository<CateProduct,Long> {

    @Query(value ="SELECT c.id as id, c.ad as cad, p.name as pname, p.image as image, p.text as text , p.price as price FROM category c inner join product p on c.id=p.cid WHERE c.id=?1" ,  nativeQuery = true)
    List<CateProduct>  cateProductList(Long id);

    @Query(value ="SELECT c.id as id, c.ad as cad, p.name as pname, p.image as image, p.text as text , p.price as price FROM category c inner join product p on c.id=p.cid WHERE p.id=?1" ,  nativeQuery = true)
    CateProduct cateProductByıd(Long id);

}
