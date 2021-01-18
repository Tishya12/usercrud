package com.paytm.usercrud.Controller;


import com.paytm.usercrud.Dao.UserDao;
import com.paytm.usercrud.Service.UserService;
import com.paytm.usercrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        return userService.getUser(userId);
    }

    @PutMapping(value = "/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }

}
