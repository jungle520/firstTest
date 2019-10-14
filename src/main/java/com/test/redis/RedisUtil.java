package com.test.redis;

import com.test.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangjiang on 2019/10/12.
 */
@Service
public class RedisUtil {



        @Autowired
        @Qualifier("redisTemplate")
        private RedisTemplate<Object, Object> redisTemplate;

    public boolean save(Map<String, Object> map, User user) {
        try {
            redisTemplate.opsForHash().putAll(user.getId(),map);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
