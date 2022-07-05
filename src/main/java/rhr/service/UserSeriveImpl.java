package rhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rhr.dao.UserRepository;
import rhr.po.User;

@Service
public class UserSeriveImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user =  userRepository.findByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public User saveUser(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAvatar(null);
        User user1 = userRepository.save(user);
        return user1;
    }
}
