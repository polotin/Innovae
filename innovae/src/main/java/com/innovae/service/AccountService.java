package com.innovae.service;

import com.innovae.domain.UserDomain;
import com.innovae.model.User;
import com.innovae.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Polotin on 2017/5/19.
 */
@Transactional(noRollbackFor = Exception.class)
@Service
public class AccountService {
    @Autowired
    @Resource
    private AccountRepository accountRepository;

    @Transactional
    public String loginWithPwd(User user){
        String userName = "";
        try{
            List<User> users= accountRepository.validAccountWhenLoggin(user.getId(), user.getPassword());
            if(users.size() == 0){
                return userName;
            }else {
                //Login success
                userName = users.get(0).getName();
                return userName;
            }
        }catch (Exception e){
            throw e;
        }
    }

    public UserDomain UserLogin(User user)throws Exception{
        UserDomain userDomain;
        String userName = loginWithPwd(user);
        //login success
        if(userName != null && userName != ""){
            userDomain = new UserDomain(0, user.getId(), userName);
        }else {
            userDomain = new UserDomain(1, user.getId(), userName);
        }
        return userDomain;
    }
}
