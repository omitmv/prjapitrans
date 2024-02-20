package com.prjapitrans.domain;

import lombok.Getter;
import lombok.Setter;

public class UsuarioResponse {

  @Getter
  @Setter
  private Long cdUsuario;

  @Getter
  @Setter
  private String login;

  @Getter
  @Setter
  private String senha;

}
