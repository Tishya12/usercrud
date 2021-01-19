package com.paytm.usercrud.Service;

import com.paytm.usercrud.Dao.UserDao;
import com.paytm.usercrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User addUser(User user) {
        return userDao.save(user);
    }

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public User getUser(int userId) {
        Optional<User> optionalUser = userDao.findById(userId);
        return optionalUser.orElse(null);
    }

    public User updateUser(int userId, User user) {
        User existingUser=userDao.findById(user.getUserId()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setMobileNumber(user.getMobileNumber());
        existingUser.setEmailID(user.getEmailID());
        existingUser.setAddress1(user.getAddress1());
        existingUser.setAddress2(user.getAddress2());
        return userDao.save(existingUser);
//        user.setUserId(userId);
//        return userDao.save(user);
    }

    public String deleteUser(int userId) {
        userDao.deleteById(userId);
      return "user removed!!";
    }
   public List<User> findByEmailID(String emailid) { return userDao.findByEmailID(emailid); }
    public List<User> findbyUserName(String username) { return userDao.findByUserName(username); }
  public List<User> findbyMobileNumber(String mobilenumber) {return userDao.findByMobileNumber(mobilenumber);}
}
