package rhr.service;

import rhr.po.User;

public interface UserService {

    User checkUser(String username,String password);

    User saveUser(String username,String password);
}
