package edu.ethan.cartoon.service.impl;

import edu.ethan.cartoon.dao.ICartoonDao;
import edu.ethan.cartoon.entity.CartoonInfo;
import edu.ethan.cartoon.entity.Collect;
import edu.ethan.cartoon.entity.Record;
import edu.ethan.cartoon.entity.User;
import edu.ethan.cartoon.service.ICartoonService;
import edu.ethan.cartoon.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/19
 */
@Service("cartoonService")
@Transactional(rollbackFor = RuntimeException.class)
public class CartoonServiceImpl implements ICartoonService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ICartoonDao dao;


    @Override
    public List<CartoonInfo> listCartoon(Integer pageNum, Integer pageSize) {
        try {
            List<CartoonInfo> list = dao.listCartoon(pageNum, pageSize);
            log.info("执行漫画加载！");
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public CartoonInfo getCartoonById(Integer cartoonId) {
        try {
            CartoonInfo cartoonInfo = dao.getCartoonById(cartoonId);
            log.info("查询漫画信息！");
            return cartoonInfo;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void collect(Collect collect) {
        try {
            dao.collect(collect);
            log.info("收藏漫画...");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public Collect collectOrNot(Collect collect) {
        try {
            return dao.collectOrNot(collect);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void deselectCollect(Collect collect) {
        try {
            dao.deselectCollect(collect);
            log.info("取消追漫...");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public  List<Collect> listCollect(User user) {
        try {
            return dao.listCollect(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void record(Record record) {
        try {
            dao.record(record);
            log.info("阅读记录...");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public List<Record> listRecord(User user) {
        try {
            return dao.listRecord(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public Record recordRead(Record record) {
        try {
            return dao.recordRead(record);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }
}