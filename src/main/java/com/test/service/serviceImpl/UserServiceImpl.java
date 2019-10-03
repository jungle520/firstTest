package com.test.service.serviceImpl;

import com.test.dao.User;
import com.test.dao.UserMapper;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjiang on 2019/9/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=false)
    private UserMapper userMapper;

    @Override
    public List findAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public int insertForeach(List<User> list) {


        return userMapper.insertForeach(list);
    }
}
