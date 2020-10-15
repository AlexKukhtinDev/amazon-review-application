package com.akukhtin.amazonreviewapplication.controller;

import com.akukhtin.amazonreviewapplication.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/get-most-active-users")
  public ResponseEntity<List<String>> getMostActiveUsers() {
    return ResponseEntity.ok(userService.mostActiveUsers());
  }
}
