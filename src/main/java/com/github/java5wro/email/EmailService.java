package com.github.java5wro.email;

import com.github.java5wro.ticket.TicketForEmail;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;

@Service
public class EmailService implements EmailSender {


    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String name, String eventName, String uuid, String price, String date, String userEmail) throws IOException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(userEmail);
            helper.setReplyTo("eventmail5wro@gmail.com");
            helper.setFrom("eventmail5wro@gmail.com");
            helper.setSubject("Your ticket to " + eventName);
            helper.setText("Thank you for buying ticket for our event.", false);

            PdfGenerator pdf = new PdfGenerator();
            ByteArrayDataSource attachment = new ByteArrayDataSource(pdf.createPdf(name, eventName, uuid), "aplication/pdf");
            helper.addAttachment("Ticket.pdf", attachment);
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            ByteArrayDataSource attachment1 = new ByteArrayDataSource(invoiceGenerator.invoiceGenerator(name, price, date), "aplication/xls");
            helper.addAttachment("Invoice.xls", attachment1);


        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }

    @Override
    public void sendEmail(TicketForEmail ticketForEmail) throws IOException {

        if (ticketForEmail == null) {
            throw new IllegalArgumentException("Ticket for email mustnt be null");
        }
        sendEmail(ticketForEmail.getUsername(),
                ticketForEmail.getEventName(),
                ticketForEmail.getUuid(),
                ticketForEmail.getPrice(),
                ticketForEmail.getPurchaseDate().toString(),
                ticketForEmail.getEmail());
    }

    public MimeMessageHelper basicMessageHelperSetup(String to, String subject, String content) throws MessagingException {

        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        helper.setTo(to);
        helper.setReplyTo("eventmail5wro@gmail.com");
        helper.setFrom("eventmail5wro@gmail.com");
        helper.setSubject(subject);
        helper.setText(content, false);

        return helper;
    }

    @Override
    public void sendEmailWithoutTicket(String to, String subject, String content) {

        try {
            javaMailSender.send(basicMessageHelperSetup(to, subject, content).getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void sendEmail(String to, String subject, String content) throws IOException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("eventmail5wro@gmail.com");
            helper.setFrom("eventmail5wro@gmail.com");
            helper.setSubject(subject);
            helper.setText(content, false);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }
}

