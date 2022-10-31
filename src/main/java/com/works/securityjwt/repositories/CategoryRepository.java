package com.works.securityjwt.repositories;

import com.works.securityjwt.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    boolean existsByAdEqualsIgnoreCase(String ad);

    @Override
    Optional<Category> findById(Long id);
}
