package com.zzh.mail.service.impl;

import com.zzh.mail.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {

    Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String form;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(form);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送");
        } catch (Exception e){
            logger.error("sendSimpleMail",e);
        }
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {

        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            mailSender.send(message);
            logger.info("HTML邮件已经发送");
        }catch (Exception e ){
            logger.error("sendHtmlMail",e);
        }

    }

    @Override
    public void sendAttachmensMail(String to, String subject, String content, String filePath) {

        MimeMessage message = mailSender.createMimeMessage();

        try{

            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName,file);
            mailSender.send(message);
            logger.info("带附件的邮件发送");
        }catch (Exception e) {
            logger.error("sendAttachmensMail",e);

        }

    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {

        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            mailSender.send(message);
            logger.info("静态资源邮件发送");
        }catch (Exception e){
            logger.error("sendInlineResourceMail",e);
        }

    }
}
