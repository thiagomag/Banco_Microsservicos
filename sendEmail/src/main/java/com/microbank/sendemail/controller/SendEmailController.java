package com.microbank.sendemail.controller;

import com.microbank.sendemail.entity.Email;
import com.microbank.sendemail.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sendemail")
public class SendEmailController {

    private final SendEmailService service;

    @PostMapping
    public String sendEmail(@RequestBody Email email) {
        return service.sendEmail(email);
    }
}
