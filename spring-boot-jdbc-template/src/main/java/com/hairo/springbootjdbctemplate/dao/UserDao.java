package com.hairo.springbootjdbctemplate.dao;

import com.hairo.springbootjdbctemplate.entity.User;

/**
 * @author Hairo
 * @date 2020/6/28 16:17
 */
public interface UserDao {

    Boolean insertUser(User user);
}
