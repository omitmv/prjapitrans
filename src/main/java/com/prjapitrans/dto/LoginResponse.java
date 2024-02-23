package com.prjapitrans.dto;

import lombok.Getter;
import lombok.Setter;

public class LoginResponse {
  @Getter
  @Setter
  private Boolean auth;

  @Getter
  @Setter
  private String token;

}
