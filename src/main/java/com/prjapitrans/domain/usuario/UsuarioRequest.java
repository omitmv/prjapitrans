package com.prjapitrans.domain.usuario;

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
