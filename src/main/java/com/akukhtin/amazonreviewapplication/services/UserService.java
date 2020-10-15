package com.akukhtin.amazonreviewapplication.services;

import com.akukhtin.amazonreviewapplication.dto.UserDto;
import java.util.List;

public interface UserService {
  List<String> mostActiveUsers();
}
