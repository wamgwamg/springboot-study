package com.example.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : wangye
 * @date: 2020-09-14
 * @description: 邮件发送
 */
@Controller
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        //发件人
        msg.setFrom("");
        //密送方邮箱地址
        msg.setBcc();
        //// 抄送方邮箱地址
        msg.setCc();
        //收件人
        msg.setTo("");
        //邮件主题
        msg.setSubject("测试邮件主题");
        //邮件内容
        msg.setText("这是测试邮件内容");
        try {
            javaMailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
