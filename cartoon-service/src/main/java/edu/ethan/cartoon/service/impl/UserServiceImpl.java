package edu.ethan.cartoon.service.impl;

import edu.ethan.cartoon.dao.IUserDao;
import edu.ethan.cartoon.entity.User;
import edu.ethan.cartoon.service.IUserService;
import edu.ethan.cartoon.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/9
 */
@Service("userService")
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao dao;

    @Override
    public List<User> listUser() {
        try {
            List<User> list = dao.listUser();
            log.info("执行用户查询！");
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public Integer save(User user) {
        try {

            if (dao.getUserByNumber(user) == null){
                dao.saveUser(user);
                log.info("执行用户添加！");
                return 200;
            }
            return 500;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public User login(User user) {
        try {
            System.out.println("login...");
            log.info("执行用户登录！");
            return  dao.login(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }


    @Override
    public User getUserByNumber(User user){
        try {
            System.out.println("load...");
            log.info("获取用户个人信息！");
            return  dao.getUserByNumber(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void updatePersonage(User user){
        try {
            System.out.println("update...");
            dao.updatePersonage(user);
            log.info("修改用户个人信息！");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }
}