package com.akukhtin.amazonreviewapplication.services;

import com.akukhtin.amazonreviewapplication.dto.UserDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface UserService {
  List<UserDto> mostActiveUsers(Pageable pageable);
}
