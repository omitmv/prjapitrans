package com.prjapitrans.dto;

import lombok.Getter;
import lombok.Setter;

public class ResultResponse {

  @Getter
  @Setter
  private Object result;

  public ResultResponse(Object value) {
    this.result = value;
  }

}
