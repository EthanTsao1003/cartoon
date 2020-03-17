package edu.ethan.cartoon.service;

import edu.ethan.cartoon.entity.User;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/9
 */
public interface IUserService {

    List<User> listUser();

    Integer save(User user);

    User login(User user);

    User getUserByNumber(User user);

    void updatePersonage(User user);
}