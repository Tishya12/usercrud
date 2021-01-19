package com.paytm.usercrud.Dao;

import com.paytm.usercrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    @Override
    List<User> findAll();
    public List<User> findByEmailID(String emailID);
    public List<User> findByUserName(String userName);
    public List<User> findByMobileNumber(String mobileNumber);
}
