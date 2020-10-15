package com.akukhtin.amazonreviewapplication.services.impl;

import com.akukhtin.amazonreviewapplication.repository.UserRepository;
import com.akukhtin.amazonreviewapplication.services.UserService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private static final long SIZE_SEARCH = 1000;

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<String> mostActiveUsers() {
    final List<String> users = userRepository.mostActiveUsers();
    return users
            .stream()
            .sorted(Comparator.reverseOrder())
            .limit(SIZE_SEARCH)
            .collect(Collectors.toList());
  }
}
