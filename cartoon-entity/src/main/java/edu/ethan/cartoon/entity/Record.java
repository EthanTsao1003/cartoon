/**
 * @Classname Record
 * @Description TODO
 * @Date 2020/2/22 13:14
 * @Created by Administrator
 */

package edu.ethan.cartoon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Record {

    private Integer recordId;
    private CartoonInfo cartoonInfo;
    private User user;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date time;
    private String onRecord;
    private String judge;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public CartoonInfo getCartoonInfo() {
        return cartoonInfo;
    }

    public void setCartoonInfo(CartoonInfo cartoonInfo) {
        this.cartoonInfo = cartoonInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOnRecord() {
        return onRecord;
    }

    public void setOnRecord(String onRecord) {
        this.onRecord = onRecord;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }
}
