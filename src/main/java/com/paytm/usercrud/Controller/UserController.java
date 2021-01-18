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
    private UserService service;

    @PostMapping
    public User addCustomer(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping
    public List<User> getCustomers() {
        return service.getUsers();
    }

    @GetMapping(value = "/{userId}")
    public User getCustomer(@PathVariable("userId") int userId) {
        return service.getUser(userId);
    }

    @PutMapping(value = "/{userId}")
    public User updateCustomer(@PathVariable("userId") int userId, @RequestBody User user) {

        return service.updateUser(userId, user);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteCustomer(@PathVariable("userId") int userId) {
        service.deleteUser(userId);
    }

}
