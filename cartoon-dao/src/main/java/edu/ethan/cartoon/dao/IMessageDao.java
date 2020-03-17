/**
 * @Classname IMessage
 * @Description TODO
 * @Date 2020/2/21 14:12
 * @Created by Administrator
 */

package edu.ethan.cartoon.dao;

import edu.ethan.cartoon.entity.Feedback;
import edu.ethan.cartoon.entity.Message;
import edu.ethan.cartoon.entity.User;

import java.util.List;

public interface IMessageDao {

    /**
     * 写短信
     * @param message
     */
    void saveMessage(Message message);

    /**
     * 获取收到的信件
     * @param user
     * @return
     */
    List<Message> inbox(User user);

    /**
     * 发件箱
     * @param user
     * @return
     */
    List<Message> outbox(User user);

    /**
     * 意见反馈
     * @param feedback
     */
    void feedback(Feedback feedback);
}
