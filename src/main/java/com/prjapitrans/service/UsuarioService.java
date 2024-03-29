package com.prjapitrans.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prjapitrans.domain.Usuario;
import com.prjapitrans.repository.UsuarioRepository;

@Service
public class UsuarioService {

  private static final Logger LOGGER = LogManager.getLogger(UsuarioService.class);

  @Autowired
  private UsuarioRepository usuarioRepository;

  public List<Usuario> getAlltbCtrUsuario() {
    return usuarioRepository.findAll();
  }

  public Usuario getByLoginAndSenhaMD5(String login, String senha) throws JsonProcessingException {
    LOGGER.info("####### DEBUG 1: " + login + " - " + senha);
    Usuario usuario = usuarioRepository.getByLoginAndSenha(login, senha);
    ObjectMapper mapper = new ObjectMapper();
    LOGGER.info("####### DEBUG 2: " + mapper.writeValueAsString(usuario));
    return usuario;
  }

  public Usuario getByLogin(String login) throws JsonProcessingException {
    LOGGER.info("####### DEBUG 3: " + login);
    ObjectMapper mapper = new ObjectMapper();
    Usuario usuario = new Usuario();
    if (login.equals(null)) {
      return null;
    } else {
      if (isValidObject(login)) {
        Usuario user = mapper.readValue(login, Usuario.class);
        usuario = usuarioRepository.findByLogin(user.getLogin());
      } else {
        usuario = usuarioRepository.findByLogin(login);
      }
      LOGGER.info("####### DEBUG 4: " + mapper.writeValueAsString(usuario));
      return usuario;
    }
  }

  public boolean isValidObject(String variable) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      Object obj = objectMapper.readValue(variable, Object.class);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
