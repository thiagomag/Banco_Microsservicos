package com.microbank.sendemail.service;

import com.microbank.sendemail.entity.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendEmailService {

    private final JavaMailSender mailSender;
    private static final String FROM = "microbankinvestimentos@gmail.com";

    public String sendEmail(Email email) {
        var message = new SimpleMailMessage();
        message.setFrom(FROM);
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getMessage());
        mailSender.send(message);

        return "Mail send!";
    }
}
