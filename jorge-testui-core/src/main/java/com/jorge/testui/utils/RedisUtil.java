/**
 * jorge-testui-parent
 * <p>
 * Copyright 2014 Acooly.cn, Inc. All rights reserved.
 *
 * @author Administrator
 * @date 2020-05-19 17:58
 */
package com.jorge.testui.utils;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author huangqingling
 * @date 2020-05-19 17:58
 */

@Component("redisUtil")
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valOpsStr;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valOpsObj;

    @Resource(name = "redisTemplate")
    private HashOperations<String,String,String> hashOperations;

    /**
     * 获取所有的key
     * @return
     */
    public Set<String> getkeys() {
        Set<String> set = this.stringRedisTemplate.keys("*");
        return set;
    }
    /**
     * 获取某个folder下所有的key
     * @param folder
     * @return
     */
    public Set<String> getkeys(String folder) {
        Set<String> set = this.stringRedisTemplate.keys(folder + "*");
        return set;
    }

    /**
     * 设置hash缓存
     * @param key
     * @param hashKey
     * @param value
     * @param expireTime seconds
     * @return
     */
    public void setHash(String key,String hashKey,String value,Long expireTime){
        hashOperations.put(key, hashKey, value);
        if (null != expireTime) {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
    }
    /**
     * 获取一组hash值
     * @param key
     * @param hashKey
     * @return
     */
    public List<String> getHash(String key,String... hashKey){
        return hashOperations.multiGet(key,Arrays.asList(hashKey));
    }

    /**
     * 设置hash缓存
     * @param key
     * @param map
     * @return
     */
    public void hset(String key, Map<String, String> map){
        hashOperations.putAll(key, map);
    }

    /**
     * 获取一个hash值
     * @param key
     * @param hashKey
     * @return
     */
    public String hget(String key,String hashKey){
        return hashOperations.get(key, hashKey);
    }

    /**
     * 根据指定o获取Object
     *
     * @param o
     * @return
     */
    public Object getObj(Object o) {
        return valOpsObj.get(o);
    }

    /**
     * 缓存
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        set(key, value, null);
    }

    /**
     * 设置obj缓存
     *
     * @param key
     * @param value
     * @param expireTime 单位是秒
     */
    public void set(String key, Object value, Long expireTime) {
        valOpsObj.set(key, value);
        if (null != expireTime) {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
    }

    public void expire(String key, Long expireTime) {
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<String> keys = stringRedisTemplate.keys(pattern);
        if (keys.size() > 0)
            stringRedisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public boolean remove(final String key) {
        if (StringUtils.isBlank(key) || !exists(key)) {
            return false;
        } else {
            return stringRedisTemplate.delete(key);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public boolean compareAndRemove(final String key, final String value) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            return false;
        }
        String cacheValue = this.get(key);
        if (value.equals(cacheValue)) {
            return stringRedisTemplate.delete(key);
        } else {
            return false;
        }
    }

    /**
     * 判断缓存中是否有对应的key
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 判断缓存中是否有对应的hash key
     * @param key
     * @param hashKey
     * @return
     */
    public boolean exists(String key,String hashKey){
        return hashOperations.hasKey(key, hashKey);
    }

    /**
     * 获取一条缓存数据
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        return valOpsStr.get(key);
    }
//	/**
//	 * Description: 未完善<br>
//	 * @author jiangL
//	 * @date: 2017年8月18日 下午4:48:19
//	 * @version V3.0
//	 * @since JDK 1.8
//	 * @return
//	 * @throws Exception
//	 */
//	public <T> List<T> sortPageList(String key,String subKey,String by,boolean isDesc,boolean isAlpha,int off,int num) throws  Exception{
//        SortQueryBuilder<String> builder = SortQueryBuilder.sort(key);
////        builder.by(subKey+"*->"+by);
////        builder.get("#");
//        builder.alphabetical(isAlpha);
//        List<T> result = new ArrayList<T>();
//        if(isDesc){
//        	builder.order(Order.ASC);
//        }
//        builder.limit(off, num);
//        List<String> list = stringRedisTemplate.opsForList().range(key, 0, 5);
//        for (String string : list) {
//			System.out.println(string);
//		}
//        List<String> cks = stringRedisTemplate.sort(builder.build());
//        for (String ck : cks) {
//        	System.out.println(ck);
//        	//得到项目对象 by(subKey+ck);
//        }
//		return result;
//	}
    /**
     * 压栈
     *
     * @param key
     * @param value
     * @return
     */
    public Long push(String key, String value) {
        return stringRedisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 读取redis存时间
     *
     * @param key
     * @return
     */
    public long getTime(final String key) {
        return stringRedisTemplate.getExpire(key);
    }

    /**
     * 更新缓存(value--为空时表删除，有值时更新)
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public void update(String key, String value, Long expireTime) {
        if (key == null || key == "") {
            return;
        }
        if (value == null || value == "") {
            remove(key);
            return;
        }
        String vaString = get(key);
        if (vaString != null) {
            remove(key);
        }
        if (expireTime == null) {
            set(key, value);
        }
        set(key, value, expireTime);
    }

    /**
     * Set {@code key} to hold the string {@code value} if {@code key} is absent
     * @param key
     * @param value
     * @return
     */
    public boolean setnx(String key, String value, Long expireTime) {
        Boolean r =  valOpsStr.setIfAbsent(key, value);
        if (r && null != expireTime) {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
        return r;
    }

    public void publishMessage(String channel, Serializable message) {
        redisTemplate.convertAndSend(channel, message);
    }

    public boolean persist(String key) {
        if (exists(key)) {
            return stringRedisTemplate.persist(key);
        } else {
            return false;
        }
    }

    /**
     *删除以什么开头的值
     */
    public void deleteByPrex(String prex) {
        Set<String> keys = this.getkeys(prex);
        if (CollectionUtils.isNotEmpty(keys)) {
            for (String key:keys) {
                redisTemplate.delete(key);
            }
        }
    }
}

