package com.haihaycode.java5.lab7.service;

import com.haihaycode.java5.lab7.model.MailInfo;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;


public interface MailerService {
    void send(MailInfo mail) throws MessagingException;

    void send(String to, String subject, String body) throws MessagingException;

    void queue(MailInfo mail);

    void queue(String to, String subject, String body);
    }
