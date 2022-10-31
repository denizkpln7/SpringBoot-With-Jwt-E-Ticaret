package com.works.securityjwt.repositories;


import com.works.securityjwt.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    boolean existsByName(String name);

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);
}
