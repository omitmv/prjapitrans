package com.prjapitrans.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationProvider implements AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'supports'");
  }

}
