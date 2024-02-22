package com.prjapitrans.dto;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {

  @Getter
  @Setter
  private String login;

  @Getter
  @Setter
  private String senha;

}
