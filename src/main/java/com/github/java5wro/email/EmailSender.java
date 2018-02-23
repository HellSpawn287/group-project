package com.github.java5wro.email;

import java.io.IOException;

public interface EmailSender {

    public void sendEmail(String to, String subject, String content) throws IOException;

}
