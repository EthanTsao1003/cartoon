package edu.ethan.cartoon.controller;


import edu.ethan.cartoon.controller.vo.ResponseVO;
import edu.ethan.cartoon.entity.Feedback;
import edu.ethan.cartoon.entity.Message;
import edu.ethan.cartoon.entity.User;
import edu.ethan.cartoon.service.IMessageService;
import edu.ethan.cartoon.service.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author Administrator
 * @date 2019/12/10
 */
@RestController("messageController")
public class MessageController extends BaseController {

    @Autowired
    private IMessageService service;


    /**
     * 写短信
     * @param message
     * @return
     */
   @PostMapping("/save_message")
   public ResponseVO saveMessage(Message message){
       try {
           service.saveMessage(message);
           return success("发送成功");
       } catch (DataAccessException e) {
           e.printStackTrace();
           return fail(500,"服务器异常");
       }
   }

    /**
     * 收件箱
     * @param session
     * @return
     */
    @GetMapping("/inbox")
    public ResponseVO inbox(HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            List<Message> listMessage = service.inbox(user);
            return success(listMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return fail(500,"服务器异常");
        }
    }

    /**
     * 发件箱
     * @param session
     * @return
     */
    @GetMapping("/outbox")
    public ResponseVO outbox(HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            List<Message> listMessage = service.outbox(user);
            return success(listMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return fail(500,"服务器异常");
        }
    }


    /**
     * 意见反馈
     * @param session
     * @param feedback
     * @return
     */
    @PostMapping("/feedback")
    public ResponseVO feedback(HttpSession session ,Feedback feedback){
        try {
            User user = (User) session.getAttribute("user");
            feedback.setUserId(user.getUserId());
            service.feedback(feedback);
            return success("提交成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500,"服务器异常");
        }
    }
}

