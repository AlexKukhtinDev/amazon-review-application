package com.akukhtin.amazonreviewapplication.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {
  @NotNull
  @NotEmpty
  private String userId;
  @NotNull
  @NotEmpty
  private String profileName;
}
