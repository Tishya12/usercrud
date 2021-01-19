package com.paytm.usercrud.Controller;


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
    public String addUser(@RequestBody User user) {
        List<User> user_email = userService.findByEmailID(user.getEmailID());
        List<User> user_username = userService.findbyUserName(user.getUserName());
        List<User> user_mobile_number = userService.findbyMobileNumber(user.getMobileNumber());

        // checking for existing Users
        if(!user_email.isEmpty())   {return "User with same emailID already exists";}
        else if (!user_username.isEmpty() ) {return "User with same userName already exists";}
        else if (!user_mobile_number.isEmpty()) {return "User with same mobileNumber already exists";}
        else  {userService.addUser(user);}
        return "User saved";

//    return userService.addUser(user);
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
    public String updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
//     return userService.updateUser(userId, user);
        User existingUser = userService.updateUser(userId,user);
        if(existingUser == null)
            return "user not existed";
        else return "user data updated";
    }

    @DeleteMapping(value = "/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {
//        userService.deleteUser(userId);
        if (userService.getUser(userId) != null) {
            userService.deleteUser(userId);
            return "User data deleted";
        } else {
            return "User doesn't exist";

        }

    }

}
