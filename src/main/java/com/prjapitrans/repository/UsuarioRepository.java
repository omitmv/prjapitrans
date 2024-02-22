package com.prjapitrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjapitrans.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Usuario getByLoginAndSenha(String login, String senha);

  Usuario findByLogin(String login);

  Usuario findByLoginAndFlAtivo(String login, String flAtivo);

}
