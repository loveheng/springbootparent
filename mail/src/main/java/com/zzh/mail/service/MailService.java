package com.zzh.mail.service;

public interface MailService {

    public void sendSimpleMail(String to,String subject,String content);
    public void sendHtmlMail(String to,String subject,String content);
    public void sendAttachmensMail(String to,String subject,String content,String filePath);
    public void sendInlineResourceMail(String to,String subject,String content,String rscPath,String rscId);

}
