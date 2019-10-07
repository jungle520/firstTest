package com.test.mail;

import com.example.demo.MybatisTestApplication;
import com.test.mail.service.SendMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wangjiang on 2019/10/7.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= MybatisTestApplication.class)
public class SendemailApplicationTestsTest {

    /**
     * 注入发送邮件的接口
     */
    @Autowired
    private SendMailService sendMailService;

    /**
     * 测试发送文本邮件
     */
    @Test
    public void sendmail() {
        sendMailService.sendSimpleMail("851731067@qq.com", "主题：你好普通邮件", "内容：第一封邮件");
    }

    @Test
    public void sendmailHtml() {
        sendMailService.sendHtmlMail("851731067@qq.com", "主题：你好html邮件", "<h1>内容：第一封html邮件</h1>");
    }
}