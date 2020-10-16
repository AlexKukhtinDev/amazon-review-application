package com.akukhtin.amazonreviewapplication.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "product_id")
  private String productId;
  @Column(name = "helpfulness_denominator")
  private Long helpfulnessDenominator;
  @Column(name = "helpfulness_nominator")
  private Long helpfulnessNominator;
  @Column(name = "score")
  @Min(0)
  @Max(5)
  private Long score;
  @Column(name = "summary")
  private String summary;
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "id",insertable = false, updatable = false)
  private List<Comment> comment;

  public Product(String productId, Long helpfulnessDenominator, Long helpfulnessNominator,
                 @Min(0) @Max(5) Long score, String summary) {
    this.productId = productId;
    this.helpfulnessDenominator = helpfulnessDenominator;
    this.helpfulnessNominator = helpfulnessNominator;
    this.score = score;
    this.summary = summary;
  }
}
