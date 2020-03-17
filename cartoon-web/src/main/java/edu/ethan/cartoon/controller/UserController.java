package edu.ethan.cartoon.controller;



import edu.ethan.cartoon.controller.vo.ResponseVO;
import edu.ethan.cartoon.entity.Personage;
import edu.ethan.cartoon.entity.User;
import edu.ethan.cartoon.service.IUserService;
import edu.ethan.cartoon.service.exception.DataAccessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * @author Administrator
 * @date 2019/12/10
 */
@RestController("userController")
public class UserController extends BaseController {

    @Autowired
    private IUserService service;

    /**
     * 用户注册
     * @param user
     * @return
     */
   @PostMapping("/save")
   public ResponseVO saveUser(User user){
       try {
           if (user.getUserNumber().contains("@")){
               user.setUserEmail(user.getUserNumber());
           }
           else{
               user.setUserTel(user.getUserNumber());
           }
           user.setUserName(user.getUserNumber());
           Integer code = service.save(user);
           if (code == 500){
              return fail(code, "该账号已被注册");
           }
           return success("注册成功");
       } catch (DataAccessException e) {
           e.printStackTrace();
           return fail(500,"服务器异常");
       }
   }

    /**
     * 用户登录
     * @param user
     * @param session
     * @return
     */
    @GetMapping("/login")
    public ResponseVO<User> login(User user, HttpSession session){
        try {

            User loginUser = service.login(user);
            if ( loginUser == null ){
                return fail(500,"用户名或密码错误");
            }
            session.setAttribute("user",loginUser);
            return success(loginUser);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500,"服务器异常,请稍后再试");
        }
    }


    /**
     * 用户注销
     * @param user
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public ResponseVO<User> logout(User user, HttpSession session){
        try {
            session.removeAttribute("user");
            return success("注销成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500,"服务器异常,请稍后再试");
        }
    }

    /**
     * 判断用户是否登录
     * @param session
     * @param response
     * @return
     */
    @GetMapping("/judge")
    public ResponseVO personage(HttpSession session, HttpServletResponse response){
        try {
            return success("用户已登录");
        } catch (Exception e) {
            e.printStackTrace();
            return  fail(500,"服务器异常,请稍后再试");
        }
    }


    /**
     * 获取用户个人信息
     * @param session
     * @return
     */
    @GetMapping("/get_user")
    public ResponseVO getUserByNumber(HttpSession session){
        try {
            User user =  (User) session.getAttribute("user");
            User userNow = service.login(user);
            session.setAttribute("user",userNow);

            if (user.getPersonage().getIntro() == null){
                user.getPersonage().setIntro("");
            }
            if (user.getPersonage().getHead() == null){
                user.getPersonage().setHead("");
            }
            if (user.getPersonage().getSex() == null){
                user.getPersonage().setSex("保密");
            }

            return success(userNow);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500,"服务器异常,请稍后再试");
        }
    }

    @PostMapping("/update_personage")
    public ResponseVO updatePersonage(User user, Personage personage){
        try {
            user.setPersonage(personage);
            service.updatePersonage(user);
            return success("修改成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500,"服务器异常");
        }
    }
}

