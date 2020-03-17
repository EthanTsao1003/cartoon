/**
 * @Classname IMessageService
 * @Description TODO
 * @Date 2020/2/21 14:23
 * @Created by Administrator
 */

package edu.ethan.cartoon.service;

import edu.ethan.cartoon.entity.Feedback;
import edu.ethan.cartoon.entity.Message;
import edu.ethan.cartoon.entity.User;

import java.util.List;

public interface IMessageService {


    void saveMessage(Message message);

    List<Message> inbox(User user);

    List<Message> outbox(User user);

    void feedback(Feedback feedback);
}
