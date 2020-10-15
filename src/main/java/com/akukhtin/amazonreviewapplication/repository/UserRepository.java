package com.akukhtin.amazonreviewapplication.repository;

import com.akukhtin.amazonreviewapplication.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
  @Query(value = "SELECT COUNT (u.userId), u.profileName FROM User u group by u.profileName order by u.profileName desc ")
  List<String> mostActiveUsers();
}
