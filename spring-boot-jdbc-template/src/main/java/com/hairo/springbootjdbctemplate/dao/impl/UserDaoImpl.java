package com.hairo.springbootjdbctemplate.dao.impl;

import com.hairo.springbootjdbctemplate.dao.UserDao;
import com.hairo.springbootjdbctemplate.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Hairo
 * @date 2020/6/28 16:33
 */
@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insertUser(User user) {
        log.debug("user->{}",user);
        int update = jdbcTemplate.update("insert into hairo_test.sys_user (user_name, user_password, user_age, user_id, address) VALUES(?, ?, ?, ?, ?)"
                , new Object[]{user.getUserName(), user.getPassword(), user.getAge(), user.getUserId(), user.getAddress()});
        log.debug("insert user result ->{}",update);
        return update > 0;
    }
}
