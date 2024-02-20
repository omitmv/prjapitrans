package com.prjapitrans.domain.usuario;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  public List<tbctrusuario> getAlltbCtrUsuario() {
    return usuarioRepository.findAll();
  }

  public tbctrusuario getByLoginAndSenha(String login, String senha) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] hashInBytes = md.digest(senha.getBytes(StandardCharsets.UTF_8));

      String hash = new BigInteger(1, hashInBytes).toString(16);

      while (hash.length() < 32) {
        hash = "0" + hash;
      }
      return usuarioRepository.getByLoginAndSenha(login, hash);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }

  public tbctrusuario getByLoginAndSenhaMD5(String login, String senha) {
    return usuarioRepository.getByLoginAndSenha(login, senha);
  }

}
