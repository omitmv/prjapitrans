package com.prjapitrans.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prjapitrans.config.JwtUtil;
import com.prjapitrans.config.UserDetailsServiceImpl;
import com.prjapitrans.domain.Usuario;
import com.prjapitrans.dto.LoginRequest;
import com.prjapitrans.service.UsuarioService;

@RestController
@RequestMapping
public class AuthController {

  private static final Logger LOGGER = LogManager.getLogger(AuthController.class);

  private JwtUtil jwtUtil;
  private UserDetailsServiceImpl userDetailsService;
  @Autowired
  private UsuarioService usuarioService;

  public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
      UserDetailsServiceImpl userDetailsService) {
    this.jwtUtil = jwtUtil;
    this.userDetailsService = userDetailsService;
  }

  @SuppressWarnings("rawtypes")
  @PostMapping("/auth")
  public ResponseEntity createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getLogin());
    LOGGER.info("####### DEBUG 1: " + userDetails.getUsername() + " - " + userDetails.getPassword());
    Usuario usuario = usuarioService.getByLoginAndSenhaMD5(authenticationRequest.getLogin(),
        authenticationRequest.getSenha());
    ObjectMapper json = new ObjectMapper();
    LOGGER.info("####### DEBUG 3: " + json.writeValueAsString(usuario));
    final String jwt = jwtUtil.generateToken(json.writeValueAsString(usuario));
    LOGGER.info("####### DEBUG 4: " + jwt);

    return ResponseEntity.ok(jwt);
  }

}
