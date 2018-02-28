package com.github.java5wro.user.model;

public class EmailMessage {

    private String toAddres;
    private String subject;
    private String body;

    public String getToAddres() {
        return toAddres;
    }

    public void setToAddres(String toAddres) {
        this.toAddres = toAddres;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
