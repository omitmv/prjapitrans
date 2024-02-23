package com.prjapitrans.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prjapitrans.dto.SendEmailRequest;

import javax.mail.internet.MimeMessage;

@RestController
public class EmailController {

  private static final Logger LOGGER = LogManager.getLogger(EmailController.class);

  @Value("${spring.mail.username}")
  private String emailFrom;

  @Autowired
  private JavaMailSender mailSender;

  @RequestMapping(path = "/utils/sendEmail", method = RequestMethod.POST)
  public ResponseEntity<String> sendMail(@RequestBody SendEmailRequest sendEmailRequest) {
    try {
      MimeMessage mail = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mail);
      LOGGER.info("####### DEBUG 1: " + sendEmailRequest.getTo());
      helper.setTo(sendEmailRequest.getTo());
      LOGGER.info("####### DEBUG 2: " + sendEmailRequest.getSubject());
      helper.setSubject(sendEmailRequest.getSubject());
      LOGGER.info("####### DEBUG 3: " + sendEmailRequest.getBodyEmail());
      helper.setText(sendEmailRequest.getBodyEmail(), true);
      helper.setFrom(emailFrom);
      mailSender.send(mail);
      return ResponseEntity.ok("Email enviado com sucesso!");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("Erro ao enviar email.");
    }
  }
}