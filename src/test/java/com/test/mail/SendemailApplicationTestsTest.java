package com.test.mail;

import com.alibaba.fastjson.JSON;
import com.example.demo.MybatisTestApplication;
import com.test.entiy.User;
import com.test.mail.service.SendMailService;
import com.test.redis.RedisUtil;
import com.test.redis.jedis.RedisUtilone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

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


    @Autowired
    private  RedisUtil redisUtil;

    @Autowired
    private RedisUtilone redisUtilone;
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

    @Test
    public void saveUsertoRedis(){
        User user=new User();
        user.setName("jungle");
        user.setAge("20");
        user.setEmail("1212@qq.com");
        user.setId("userkey4");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put(user.getId(), JSON.toJSONString(user));
        System.out.println(redisUtil.save(map,user));
    }
    @Test
    public void saveUser(){
        User user=new User();
        user.setName("jungle");
        user.setAge("20");
        user.setEmail("1212@qq.com");
        user.setId("userkey3");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put(user.getId(), JSON.toJSONString(user));
        System.out.println(redisUtilone.set(user.getId().getBytes(),JSON.toJSONBytes(user),0));
        redisUtilone.setTest();

    }
}