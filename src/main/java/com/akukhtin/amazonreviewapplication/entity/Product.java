package com.akukhtin.amazonreviewapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Product extends BaseEntity {
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
}
