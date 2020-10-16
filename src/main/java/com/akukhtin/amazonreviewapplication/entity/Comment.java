package com.akukhtin.amazonreviewapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "text", length = 100000)
  private String text;
  @ManyToOne
  @JoinColumn(name = "id",insertable = false, updatable = false)
  private Product product;

  public Comment(String text) {
    this.text = text;
  }
}
