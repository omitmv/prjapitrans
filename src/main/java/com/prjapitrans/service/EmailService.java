package com.prjapitrans.service;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.prjapitrans.dto.SendEmailRequest;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailService {

  private JavaMailSenderImpl mailSender;

  public EmailService(SendEmailRequest sendEmailRequest) {
    mailSender = new JavaMailSenderImpl();

    // Configurações do servidor SMTP
    mailSender.setHost(sendEmailRequest.getSmtp());
    mailSender.setPort(Integer.valueOf(sendEmailRequest.getSmtpPort()));

    // Autenticação
    mailSender.setUsername(sendEmailRequest.getEmailFrom());
    mailSender.setPassword(sendEmailRequest.getEmailPassword());

    // Configurações adicionais
    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");
  }

  public void sendEmail(String to, String subject, String text) {
    try {
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(text, true); // O segundo parâmetro indica que o texto é HTML

      mailSender.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
