package com.akukhtin.amazonreviewapplication.controller;

import com.akukhtin.amazonreviewapplication.dto.UserDto;
import com.akukhtin.amazonreviewapplication.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/most-active")
  public ResponseEntity<List<UserDto>> getMostActiveUsers(Pageable pageable) {
    return ResponseEntity.ok(userService.mostActiveUsers(pageable));
  }
}
