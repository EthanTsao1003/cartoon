package edu.ethan.cartoon.service;

import edu.ethan.cartoon.entity.CartoonInfo;
import edu.ethan.cartoon.entity.Collect;
import edu.ethan.cartoon.entity.Record;
import edu.ethan.cartoon.entity.User;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/12/19
 */
public interface ICartoonService {

    List<CartoonInfo> listCartoon(Integer pageNum, Integer pageSize);

    CartoonInfo getCartoonById(Integer cartoonId);

    void collect(Collect collect);

    Collect collectOrNot(Collect collect);

    void deselectCollect(Collect collect);

    List<Collect> listCollect(User user);

    void record(Record record);

    List<Record> listRecord(User user);

    Record recordRead(Record record);

}