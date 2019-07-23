package com.aaa.common.utils.redis;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @Author: 陈建
 * @Date: 2019/5/20 0020 10:45
 * @Version 1.0
 */
public class RedisCacheTransfer {
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
