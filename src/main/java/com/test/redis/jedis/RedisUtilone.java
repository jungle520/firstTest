package com.test.redis.jedis;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * Created by wangjiang on 2019/10/13.
 */
@Service
public class RedisUtilone {

    private static final ch.qos.logback.classic.Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(RedisUtilone.class);


    @Autowired
    private JedisPool jedisPool;


    public String set(byte[] key, byte[] value,int indexdb) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.set(key, value);
        } catch (Exception e) {

            log.error(e.getMessage());
            return "0";
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    public String setTest(){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(1);
            for(int i=0;i<10000; i++) {
                jedis.pfadd("jungle","user"+i);


            }
            long count=jedis.pfcount("jungle");
            System.out.println("10000"+count);
            return "haha";
        } catch (Exception e) {

            log.error(e.getMessage());
            return "0";
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }


    }


}
