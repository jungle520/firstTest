package com.test.redis.UserRepositoryServiceImpl;

import com.test.dao.User;
import com.test.redis.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by wangjiang on 2019/9/14.
 */
@Repository("userRepositoryByRedis")
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean save(User user) {
        try {
            redisTemplate.opsForValue().set(String.valueOf(user.getId()), user);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public User findUser(Long id) {
        try {
            return (User) redisTemplate.opsForValue().get(String.valueOf(id));
        } catch (Exception e){
            System.out.println(e.toString());
            return null;
        }

    }
}
