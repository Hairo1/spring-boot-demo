package com.hairo.springbootcache.dao;

import com.hairo.springbootcache.entity.User;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hairo
 * @date 2020/7/3 15:08
 */

@Service
public class UserDao implements Serializable {
    public List<User> initUsers() {
        System.out.println("数据库获取10个用户");
        List<User> userList = new ArrayList<>(10);
        for (int i = 1; i < 10; i++) {
            userList.add(new User("海羅" + i + "号", i + ""));
        }
        return userList;
    }
}
