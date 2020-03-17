package edu.ethan.cartoon.service;

import edu.ethan.cartoon.dao.config.AppConfig;
import edu.ethan.cartoon.entity.CartoonInfo;
import edu.ethan.cartoon.entity.Collect;
import edu.ethan.cartoon.entity.Message;
import edu.ethan.cartoon.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class IUserServiceTest {

    @Test
    public void save() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        IUserService service = context.getBean("userService", IUserService.class);
//        User user = new User();
//        user.setUserNumber("admin");
//        user.setUserPassword("admin");
//        user.setUserName("Ethan");
//        user.setUserEmail("1052285754@qq.com");
//        user.setUserTel("13397828622");
//        service.save(user);
    }

    @Test
    public void listUser() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IUserService service = context.getBean("userService", IUserService.class);
        List<User> list = service.listUser();
       list.forEach(user -> System.out.println(user.getUserId()));
    }

    @Test
    public void listCartoon() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ICartoonService service = context.getBean("cartoonService", ICartoonService.class);
//        List<CartoonInfo> list = service.listCartoon(0,10);
//        list.forEach(cartoon -> System.out.println(cartoon.getCartoonTitle()));
        Collect collect =  new Collect();
        CartoonInfo cartoonInfo = new CartoonInfo();
        User user = new User();
        cartoonInfo.setCartoonId(4);
        user.setUserId(1001);
        collect.setCartoonInfo(cartoonInfo);
        collect.setUser(user);
        service.deselectCollect(collect);
    }

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IMessageService service = context.getBean("messageService", IMessageService.class);

        Message message = new Message();
        message.setContent("hahahahahahaha");
        message.setExporter(1003);
        message.setReceiver(1001);

        service.saveMessage(message);
    }
}