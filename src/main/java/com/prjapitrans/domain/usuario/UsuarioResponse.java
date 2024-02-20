package com.prjapitrans.domain.usuario;

import lombok.Getter;
import lombok.Setter;

public class UsuarioResponse {

  @Getter
  @Setter
  private Long CdUsuario;

  @Getter
  @Setter
  private String Login;

  @Getter
  @Setter
  private String Senha;

}
