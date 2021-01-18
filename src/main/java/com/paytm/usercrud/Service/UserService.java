package com.paytm.usercrud.Service;

import com.paytm.usercrud.Dao.UserDao;
import com.paytm.usercrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.paytm.usercrud.model.User.*;

@Component
public class UserService {


        @Autowired
        private UserDao repo;



        public User addUser(User user) {
            return repo.save(user);
        }

        public List<User> getUsers() {
            return (List<User>) repo.findAll();
        }

        public User getUser(int userId) {

//            Optional<User> optionalUser;
//            optionalUser = repo.findById(userId);
//
//            if(!optionalUser.isPresent())     //adding exception
//                throw new CustomerNotFoundException("Customer Record is not available...");

            return repo.findById(userId).get();
        }

        public User updateUser(int userId, User user) {
//            system.out.println(Use)
            user.setUserId(userId);
            return repo.save(user);
        }

        public void deleteUser(int userId) {
            repo.deleteById(userId);
        }
}
