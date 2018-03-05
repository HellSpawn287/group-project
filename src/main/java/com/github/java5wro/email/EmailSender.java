package com.github.java5wro.email;

import com.github.java5wro.ticket.TicketForEmail;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailSender {

    public void sendEmail(String name, String eventName, String uuid, String price, String date, String userEmail) throws IOException;

    void sendEmail(TicketForEmail ticketForEmail) throws IOException;

    MimeMessageHelper basicMessageHelperSetup(String to, String subject, String content) throws MessagingException;

    void sendEmailWithoutTicket(String to, String subject, String content);

    void sendEmail(String to, String subject, String content) throws IOException;
}
