package com.prjapitrans.controller;

import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.prjapitrans.dto.LoginResponse;
import com.prjapitrans.dto.ResultResponse;
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

  @PostMapping("/auth")
  public ResponseEntity<ResultResponse> createAuthenticationToken(@RequestBody LoginRequest loginRequest) {
    try {
      ObjectMapper json = new ObjectMapper();
      byte[] decodeBytes = Base64.getDecoder().decode(loginRequest.getValue());
      String decodeString = new String(decodeBytes);
      Usuario authenticationRequest = json.readValue(decodeString, Usuario.class);
      final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getLogin());
      String jwt = "";
      LOGGER.info("####### DEBUG 1: " + userDetails.getUsername() + " - " + userDetails.getPassword());
      Usuario usuario = usuarioService.getByLoginAndSenhaMD5(authenticationRequest.getLogin(),
          authenticationRequest.getSenha());
      if (!usuario.equals(null)) {
        LOGGER.info("####### DEBUG 2: " + json.writeValueAsString(usuario));
        jwt = jwtUtil.generateToken(json.writeValueAsString(usuario));
        LOGGER.info("####### DEBUG 3: " + jwt);
        LoginResponse response = new LoginResponse();
        ResultResponse resultResponse = new ResultResponse(response);
        response.setAuth(true);
        response.setToken(jwt);
        return ResponseEntity.ok(resultResponse);
      } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

}
