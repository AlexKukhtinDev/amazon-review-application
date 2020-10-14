package com.akukhtin.amazonreviewapplication.repository;

import com.akukhtin.amazonreviewapplication.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseEntityRepository extends JpaRepository <BaseEntity, Long> {
}
