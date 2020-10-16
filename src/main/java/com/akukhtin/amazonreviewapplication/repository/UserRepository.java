package com.akukhtin.amazonreviewapplication.repository;

import com.akukhtin.amazonreviewapplication.entity.User;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
  @Query(value = "SELECT COUNT(u.userId), u.profileName FROM User u " +
          "GROUP BY u.profileName " + "order by u.profileName desc ")
  List<Object[]> mostActiveUsers(Pageable pageable);
}
