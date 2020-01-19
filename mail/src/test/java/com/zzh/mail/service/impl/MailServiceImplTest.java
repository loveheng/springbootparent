package com.zzh.mail.service.impl;

import com.zzh.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;


    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("qq1663867295@outlook.com","test simple mail","hello this is simple mail");

    }

    @Test
    public void sendHtmlMail() {

        String content ="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("qq1663867295@outlook.com","test simple mail",content);
    }

    @Test
    public void sendAttachmensMail() {

        String filePaTh = "";
        mailService.sendAttachmensMail("qq1663867295@outlook.com","mail附件test","该邮件带附件",filePaTh);
    }

    @Test
    public void sendInlineResourceMail() {

        String rscId = "neooo6";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";
        mailService.sendInlineResourceMail("qq1663867295@outlook.com", "主题：这是有图片的邮件", content, imgPath, rscId);

    }

    @Test
    public void sendTemplateMail() {

        Context context = new Context();
        context.setVariable("id","006");
        String emailContent = templateEngine.process("emailTemplate",context);
        mailService.sendHtmlMail("qq1663867295@outlook.com","test simple mail",emailContent);
    }

}