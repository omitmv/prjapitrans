package com.prjapitrans.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  private static final Logger LOGGER = LogManager.getLogger(JwtAuthenticationEntryPoint.class);

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {
    LOGGER.info("####### DEBUG: " + request);
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Não autorizado");
  }

}
