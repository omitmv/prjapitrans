package com.prjapitrans.dto;

import lombok.Getter;
import lombok.Setter;

public class SendEmailRequest {
  @Getter
  @Setter
  private String to;

  @Getter
  @Setter
  private String subject;

  @Getter
  @Setter
  private String bodyEmail;

}
