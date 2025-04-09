package com.fullstack.controller;

import com.fullstack.model.EmailModel;
import com.fullstack.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@Slf4j
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailModel emailModel) {
        log.info("Sending Email TO: " + emailModel.getToEmail());
        emailService.sendEmail(emailModel);

        return ResponseEntity.ok("Email Sent Successfully");
    }

}
