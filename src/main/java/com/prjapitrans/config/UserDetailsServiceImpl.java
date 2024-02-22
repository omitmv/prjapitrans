package com.prjapitrans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prjapitrans.domain.Usuario;
import com.prjapitrans.service.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsuarioService usuarioService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Aqui você deve implementar a lógica para carregar os detalhes do usuário a
    // partir do banco de dados.
    // Por enquanto, vamos retornar um usuário hardcoded.
    Usuario usuario;
    try {
      usuario = usuarioService.getByLogin(username);
      return User.withUsername(usuario.getLogin()).password(usuario.getSenha()).roles("USER").build();
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
}
