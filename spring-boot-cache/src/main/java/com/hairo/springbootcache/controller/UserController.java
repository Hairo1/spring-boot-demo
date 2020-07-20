package com.hairo.springbootcache.controller;

import com.hairo.springbootcache.entity.User;
import com.hairo.springbootcache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hairo
 * @date 2020/7/3 15:16
 */
@RestController
public class UserController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/get")
    public List<User> getUsers(){
        return cacheService.getUsers();
    }

    @GetMapping("/delete")
    public void delete(){
         cacheService.deleteCache();
    }

    @GetMapping("/update")
    public void update(){
         cacheService.updateCache();
    }
}
