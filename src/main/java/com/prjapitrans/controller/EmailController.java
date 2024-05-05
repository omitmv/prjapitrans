package com.prjapitrans.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prjapitrans.dto.EmailXlsxDto;
import com.prjapitrans.dto.SendEmailRequest;
import com.prjapitrans.service.EmailService;

@RestController
public class EmailController {

  private static final Logger LOGGER = LogManager.getLogger(EmailController.class);

  @RequestMapping(path = "/utils/sendEmail", method = RequestMethod.POST)
  public ResponseEntity<String> sendMail(@RequestBody SendEmailRequest sendEmailRequest) {
    try {
      EmailService emailService = new EmailService(sendEmailRequest);
      for (EmailXlsxDto email : sendEmailRequest.getEmails()) {
        LOGGER.info("####### DEBUG 1: " + email.getEmail());
        emailService.sendEmail(email.getEmail(), sendEmailRequest.getSubject(), sendEmailRequest.getMessage());
      }
      return ResponseEntity.ok("Email enviado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("Erro ao enviar email.");
    }
  }
}