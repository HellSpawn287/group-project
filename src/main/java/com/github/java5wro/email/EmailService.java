package com.github.java5wro.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
            ByteArrayDataSource attachment = new ByteArrayDataSource(pdf.createPdf(name, eventName, uuid),"aplication/pdf");
            helper.addAttachment("Ticket.pdf",attachment);
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            ByteArrayDataSource attachment1 = new ByteArrayDataSource(invoiceGenerator.invoiceGenerator(name, price, date),"aplication/xls");
            helper.addAttachment("Invoice.xls",attachment1);



        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }
}

