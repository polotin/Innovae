package com.innovae.repository;

import com.innovae.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Polotin on 2017/5/19.
 */
@Repository
public interface AccountRepository extends JpaRepository<User, String>{
    @Query("select user from user where id=?1 and password=?2")
    List<User> validAccountWhenLoggin(String id, String password);
}
