package com.akukhtin.amazonreviewapplication.repository;

import com.akukhtin.amazonreviewapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
