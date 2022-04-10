package com.example.demo.controllers;

import com.example.demo.entities.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class UsersController
{
    private final Object locker = new Object();
    private final Map<Long, UserEntity> users = new LinkedHashMap<>();

    @PostConstruct
    private void onCreate()
    {
        users.put(1L, new UserEntity(1L, "John", "Cleese"));
        users.put(2L, new UserEntity(2L, "Robert", "de Niro"));
        users.put(3L, new UserEntity(3L, "Adam", "Sandler"));
        users.put(4L, new UserEntity(4L, "Patric", "Harris"));
    }

    @RequestMapping("/users/")
    @ResponseBody
    public Object getUsers()
    {
        synchronized (this.locker)
        {
            return this.users;
        }
    }

    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object getUser(@PathVariable Long id)
    {
        synchronized (this.locker)
        {
            return this.users.get(id);
        }
    }

    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public Object removeUser(@PathVariable Long id)
    {
        synchronized (this.locker)
        {
            return this.users.remove(id);
        }
    }

//    @RequestMapping(value = "/users/{id}/add", method = RequestMethod.POST)
//    @ResponseBody
//    public Object addUser(ResponseBody UserEntity user)
//    {
//        synchronized (this.locker)
//        {
//            return this.users.put();
//        }
//    }
}
