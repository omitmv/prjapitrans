package com.prjapitrans.domain;

import lombok.Getter;
import lombok.Setter;

public class UsuarioRequest {

  @Getter
  @Setter
  private String login;

  @Getter
  @Setter
  private String senha;

}
