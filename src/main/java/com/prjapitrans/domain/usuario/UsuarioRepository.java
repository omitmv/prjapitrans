package com.prjapitrans.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<tbctrusuario, Long> {

  tbctrusuario getByLoginAndSenha(String login, String senha);

}
