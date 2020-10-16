package com.akukhtin.amazonreviewapplication.services.impl;

import com.akukhtin.amazonreviewapplication.dto.UserDto;
import com.akukhtin.amazonreviewapplication.repository.UserRepository;
import com.akukhtin.amazonreviewapplication.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserDto> mostActiveUsers(Pageable pageable) {
    final List<Object[]> activeUsers =
            userRepository.mostActiveUsers(pageable);

    List<UserDto> userList = new ArrayList<>();
    setToUserDto(activeUsers, userList);
    sortingList(userList);
    return userList;
  }

  private void sortingList(List<UserDto> userList) {
    userList.sort((o1, o2) -> {
      final int o1UserId = Integer.parseInt(o1.getUserId());
      final int o2UserId = Integer.parseInt(o2.getUserId());
      return o2UserId - o1UserId;
    });
  }

  private void setToUserDto(List<Object[]> activeUsers, List<UserDto> userList) {
    for (Object[] activeUser : activeUsers) {
      UserDto userDto = new UserDto();
      Long id = (Long) activeUser[0];
      userDto.setUserId(Long.toString(id));
      String profileName = (String) activeUser[1];
      userDto.setProfileName(profileName);
      userList.add(userDto);
    }
  }
}
