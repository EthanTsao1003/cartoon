package edu.ethan.cartoon.entity;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * @author Administrator
 * @date 2019/12/29
 */
public class Personage {
    private Integer personageId;
    private String intro;
    private String head;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    private String sex;

    public Integer getPersonageId() {
        return personageId;
    }

    public void setPersonageId(Integer personageId) {
        this.personageId = personageId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}