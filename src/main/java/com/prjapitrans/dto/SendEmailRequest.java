package com.prjapitrans.dto;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class SendEmailRequest {
  @Getter
  @Setter
  private String smtp;

  @Getter
  @Setter
  private String smtpPort;

  @Getter
  @Setter
  private String emailFrom;

  @Getter
  @Setter
  private String emailPassword;

  @Getter
  @Setter
  private String subject;

  @Getter
  @Setter
  private String message;

  @Getter
  @Setter
  private ArrayList<EmailXlsxDto> emails;

}
