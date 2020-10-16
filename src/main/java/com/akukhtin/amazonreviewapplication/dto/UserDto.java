package com.akukhtin.amazonreviewapplication.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
  @NotNull
  @NotEmpty
  private String userId;
  @NotNull
  @NotEmpty
  private String profileName;
}
