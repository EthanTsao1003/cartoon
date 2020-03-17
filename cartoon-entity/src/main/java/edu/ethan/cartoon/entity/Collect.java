/**
 * @Classname Collect
 * @Description TODO
 * @Date 2020/2/21 18:24
 * @Created by Administrator
 */

package edu.ethan.cartoon.entity;

public class Collect {

    private Integer collectId;
    private CartoonInfo cartoonInfo;
    private User user;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
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
}
