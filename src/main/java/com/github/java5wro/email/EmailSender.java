package com.github.java5wro.email;

import java.io.IOException;

public interface EmailSender {

    public void sendEmail(String name, String eventName, String uuid, String price, String date, String userEmail) throws IOException;

}
