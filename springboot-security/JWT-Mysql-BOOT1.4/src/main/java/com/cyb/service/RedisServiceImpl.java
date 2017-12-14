package com.cyb.service;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2017年12月14日
 */
@Service
public class RedisServiceImpl {
	Log log = LogFactory.getLog(RedisServiceImpl.class);
	    @Resource
	    private RedisTemplate<String,Object> redisTemplate;

	    public void set(String key, Object value) {
	        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
	         vo.set(key, value);
	    }
	    public Object get(String key) {
	        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
	        return vo.get(key);
	    }
}
