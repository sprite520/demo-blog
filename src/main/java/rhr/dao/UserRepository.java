package rhr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rhr.po.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);
}
