package com.prjapitrans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prjapitrans.domain.Usuario;
import com.prjapitrans.dto.UsuarioRequest;
import com.prjapitrans.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping
  public ResponseEntity<List<Usuario>> getAll() {
    return ResponseEntity.ok(usuarioService.getAlltbCtrUsuario());
  }

  @GetMapping("/login")
  public ResponseEntity<Usuario> login(@RequestBody UsuarioRequest request) throws JsonProcessingException {
    return ResponseEntity.ok(usuarioService.getByLoginAndSenhaMD5(request.getLogin(), request.getSenha()));
  }

  @GetMapping("/login2")
  public ResponseEntity<String> login2(@RequestBody UsuarioRequest request) throws JsonProcessingException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String login = authentication.getName();
    return ResponseEntity.ok(login);
  }

}
