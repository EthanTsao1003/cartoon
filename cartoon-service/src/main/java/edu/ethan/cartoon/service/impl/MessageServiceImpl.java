/**
 * @Classname MessageServiceImpl
 * @Description TODO
 * @Date 2020/2/21 14:24
 * @Created by Administrator
 */

package edu.ethan.cartoon.service.impl;

import edu.ethan.cartoon.dao.IMessageDao;
import edu.ethan.cartoon.entity.Feedback;
import edu.ethan.cartoon.entity.Message;
import edu.ethan.cartoon.entity.User;
import edu.ethan.cartoon.service.IMessageService;
import edu.ethan.cartoon.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("messageService")
@Transactional(rollbackFor = RuntimeException.class)
public class MessageServiceImpl implements IMessageService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IMessageDao dao;

    @Override
    public void saveMessage(Message message) {
        try {
            dao.saveMessage(message);
            log.info("保存短信...");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public List<Message> inbox(User user) {
        try {
              List<Message> listMessage = dao.inbox(user);
            log.info("收件箱初始化...");
            return listMessage;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public List<Message> outbox(User user) {
        try {
            List<Message> listMessage = dao.outbox(user);
            log.info("发件箱初始化...");
            return listMessage;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void feedback(Feedback feedback) {
        try {
            dao.feedback(feedback);
            log.info("意见反馈...");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }
}
