package com.switchfully.youcoach.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MessageSenderNew {

    public void sendSimpleMessage(String to, String subject, String text) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("coachify.mail.service@gmail.com");
        mailSender.setPassword("Coachify123456");

        mailSender.setUsername(System.getenv("MAIL_USERNAME"));
        mailSender.setPassword("MAIL_PASSWORD");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@coachify.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}

