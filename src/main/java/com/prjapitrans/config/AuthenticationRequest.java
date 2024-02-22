package com.prjapitrans.config;

import lombok.Getter;
import lombok.Setter;

public class AuthenticationRequest {
  @Getter
  @Setter
  private String login;
  @Getter
  @Setter
  private String senha;

  // getters and setters
}
