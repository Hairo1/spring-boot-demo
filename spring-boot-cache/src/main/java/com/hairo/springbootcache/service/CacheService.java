package com.hairo.springbootcache.service;

import com.hairo.springbootcache.dao.UserDao;
import com.hairo.springbootcache.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hairo
 * @date 2020/7/3 15:02
 */
@Service
public class CacheService {

    private final UserDao userDao;

    public CacheService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 缓存方法执行的结果 并指定KEY 为 users
     * @return
     */
    @Cacheable(value = "users")
    public List<User> getUsers() {
        return userDao.initUsers();
    }

    /**
     * 移除缓存
     * @return
     */
    @CacheEvict(value = "users", allEntries = true)
    public Boolean deleteCache() {
        System.out.println("删除缓存");
        return true;
    }

    @CachePut(value = "users")
    public void updateCache() {
        System.out.println("更新缓存");
        getUsers();
    }
}
