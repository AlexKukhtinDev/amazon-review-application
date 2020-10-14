package com.akukhtin.amazonreviewapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COMMENT")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Comment extends BaseEntity {
  @Column(name = "text", length = 5000)
  private String text;
}
