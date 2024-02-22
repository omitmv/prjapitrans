package com.prjapitrans.dto;

import lombok.Getter;
import lombok.Setter;

public class RecoveryJwtDto {

  @Getter
  @Setter
  private String token;

  public RecoveryJwtDto(String token2) {
    this.token = token2.toString();
  }

}
