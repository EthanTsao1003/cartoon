package edu.ethan.cartoon.dao;

import edu.ethan.cartoon.entity.Message;
import edu.ethan.cartoon.entity.User;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/9
 */
public interface IUserDao {

    /**
     * 获取所有用户信息
     */
    List<User> listUser();

    /**
     * //用户注册
     * @param user
     */
    void saveUser(User user);

    /**
     * //登录验证
     * @param user
     * @return
     */
    User login(User user);

    /**
     * //查询该用户是否存在
     * @param user
     * @return
     */
    User getUserByNumber(User user);

    /**
     * 修改用户个人信息
     * @param user
     */
    void updatePersonage(User user);



}