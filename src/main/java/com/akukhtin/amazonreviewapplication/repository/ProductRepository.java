package com.akukhtin.amazonreviewapplication.repository;

import com.akukhtin.amazonreviewapplication.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query(value = "SELECT COUNT (p.comment), p.productId FROM Product p " +
          "group by p.productId " + "order by p.productId desc ")
  List<String> mostCommentedFoodItems();
}
