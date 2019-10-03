package com.test.controller;
import ch.qos.logback.classic.Logger;
import com.test.dao.User;
import com.test.redis.UserRepository;
import com.test.service.serviceImpl.UserServiceImpl;
import org.apache.commons.logging.Log;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wangjiang on 2019/9/13.
 */
@RestController
@RequestMapping(value = "/test")
public class UserController {
    @Autowired(required = false)
    private UserServiceImpl userService;

    @Autowired(required = false)
    private UserRepository userRepository;


    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value ="/phone", method = RequestMethod.GET)
    public List test(){
        System.out.println("进入方法");
//        User user=userDao.selectByPrimaryKey(1);
//        User user1=new User("zhangsan","12121","qwqwq");
//        if (!("null").equals(user)) {
//            return user;
//        }
//        else {
//          return user1;
//        }
        List user1=userService.findAllUser();
        return user1;
    }

    //-http://localhost:8080/test/add?name=abc&passwd=123&appid=95955542783
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public User save(@RequestParam("name") String name,
//                     @RequestParam(value = "passwd",defaultValue = "0") String passwd,
//                     @RequestParam(value = "appid",defaultValue = "0") String appid) {
//        User user = new User(name,passwd,appid);
//        userDao.insert(user);
//        return userDao.selectByPrimaryKey(user.getId());
//    }
//
//
//
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public void delete(@RequestParam("id") Integer id) {
//        userDao.deleteByPrimaryKey(id);
//    }

    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List getAllUsers(){
        List list =  userService.findAllUser();
        User user=new User();
        User user1=new User();
        user.setId(123);
        user.setAppid("121212");
        user.setName("bozi1212");
        user.setPasswd("shabibozi");
        user1.setAppid("123456789");
        user1.setPasswd("23456789");
        user1.setName("boboshabi");
        List<User> listUser=new ArrayList<User>();
        listUser.add(user);
        listUser.add(user1);
        //userService.insertForeach(listUser);
        System.out.println("yes");
        logger.info("1212121");
//        userRepository.save(user);user;
//        System.out.println(userRepository.findUser(user.getId().longValue()));
//        System.out.println("redis存储成功");

        return list;
    }




}
