package com.test.service;

import com.test.dao.User;

import java.util.List;

/**
 * Created by wangjiang on 2019/9/14.
 */
public interface UserService {

    List findAllUser();

    int insertForeach(List<User> list);
}
