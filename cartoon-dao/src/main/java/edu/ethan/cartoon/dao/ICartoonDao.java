package edu.ethan.cartoon.dao;

import edu.ethan.cartoon.entity.CartoonInfo;
import edu.ethan.cartoon.entity.Collect;
import edu.ethan.cartoon.entity.Record;
import edu.ethan.cartoon.entity.User;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/15
 */
public interface ICartoonDao {

    /**
     * 获取漫画集
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<CartoonInfo> listCartoon(Integer pageNum, Integer pageSize);

    /**
     * 获取漫画资源
     * @param cartoonId
     * @return
     */
    CartoonInfo getCartoonById(Integer cartoonId);

    /**
     * 追漫
     */
    void collect(Collect collect);

    /**
     * 是否已追漫
     * @param collect
     * @return
     */
    Collect collectOrNot(Collect collect);

    /**
     * 取消追漫
     * @param collect
     */
    void deselectCollect(Collect collect);

    /**
     * 获取用户追漫列表
     * @param user
     * @return
     */
    List<Collect> listCollect(User user);

    /**
     * 阅读记录
     * @param record
     */
    void record(Record record);

    /**
     * 获取记录列表
     * @param user
     * @return
     */
    List<Record> listRecord(User user);

    /**
     * 继续阅读
     * @return
     */
    Record recordRead(Record record);
}