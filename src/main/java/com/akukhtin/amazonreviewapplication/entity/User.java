package com.akukhtin.amazonreviewapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private String id;
  @Column(name = "user_id")
  private String userId;
  @Column(name = "profile_name")
  private String profileName;

  public User(String userId, String profileName) {
    this.userId = userId;
    this.profileName = profileName;
  }

}
