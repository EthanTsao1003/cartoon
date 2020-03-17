package edu.ethan.cartoon.dao;

import edu.ethan.cartoon.dao.config.AppConfig;
import edu.ethan.cartoon.entity.CartoonInfo;
import edu.ethan.cartoon.entity.Collect;
import edu.ethan.cartoon.entity.Message;
import edu.ethan.cartoon.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class IUserDaoTest {

    @Test
    public void saveUser() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        IUserDao dao = context.getBean(IUserDao.class);
//        User user = new User();
//        user.setUserNumber("admin");
//        user.setUserPassword("admin");
//        user.setUserName("Ethan");
//        user.setUserEmail("1052285754@qq.com");
//        user.setUserTel("13397828622");
//        dao.saveUser(user);
    }

    @Test
    public void listUser() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IUserDao dao = context.getBean(IUserDao.class);
        List<User> list = dao.listUser();
        for (User user : list) {
            System.out.println(user.getUserId());
        }
    }
    @Test
    public void listCartoon() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ICartoonDao dao = context.getBean(ICartoonDao.class);
//        List<CartoonInfo> list = dao.listCartoon(0, 10);
//        for (CartoonInfo cartoonInfo : list) {
//            System.out.println(cartoonInfo.getCartoonTitle());
//        }


//        Collect collect =  new Collect();
//        CartoonInfo cartoonInfo = new CartoonInfo();
//        User user = new User();
//        cartoonInfo.setCartoonId(4);
//        user.setUserId(1001);
//        collect.setCartoonInfo(cartoonInfo);
//        collect.setUser(user);
//         dao.deselectCollect(collect);

        User user = new User();

        user.setUserId(1001);
         dao.listCollect(user);
    }

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IMessageDao dao = context.getBean(IMessageDao.class);

        Message message = new Message();
        message.setContent("hahahahahahaha");
        message.setExporter(1003);
        message.setReceiver(1001);

        dao.saveMessage(message);
    }

}