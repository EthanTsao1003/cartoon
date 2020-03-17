/**
 * @Classname Message
 * @Description TODO
 * @Date 2020/2/21 14:08
 * @Created by Administrator
 */

package edu.ethan.cartoon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Message {


    private Integer messageId;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date time;
    private Integer state;
    private Integer exporter;
    private Integer receiver;
    private String userName;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getExporter() {
        return exporter;
    }

    public void setExporter(Integer exporter) {
        this.exporter = exporter;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
