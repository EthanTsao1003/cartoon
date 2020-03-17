package edu.ethan.cartoon.controller;

import edu.ethan.cartoon.controller.vo.ResponseVO;
import edu.ethan.cartoon.entity.CartoonInfo;
import edu.ethan.cartoon.entity.Collect;
import edu.ethan.cartoon.entity.Record;
import edu.ethan.cartoon.entity.User;
import edu.ethan.cartoon.service.ICartoonService;
import edu.ethan.cartoon.service.exception.DataAccessException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Administrator
 * @date 2019/12/19
 */
@RestController("cartoonController")
public class CartoonController extends BaseController {

    //            -Dfile.encoding=UTF-8

    @Autowired
    private ICartoonService service;

    private String cartoonUrl ;


    /**
     * 追漫
     * @param cartoonInfo
     * @param session
     * @return
     */
    @PostMapping("/collect")
    public ResponseVO collect(CartoonInfo cartoonInfo, HttpSession session){
        try {
            Collect collect = new Collect();
            User user = (User) session.getAttribute("user");
            collect.setCartoonInfo(cartoonInfo);
            collect.setUser(user);
            service.collect(collect);
            return success("追漫成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }


    /**
     * 是否已追漫
     * @param cartoonInfo
     * @param session
     * @return
     */
    @GetMapping("/collectOrNot")
    public ResponseVO collectOrNot(CartoonInfo cartoonInfo, HttpSession session){
        try {
            Collect collect = new Collect();
            User user = (User) session.getAttribute("user");
            collect.setCartoonInfo(cartoonInfo);
            collect.setUser(user);
            Collect collect2 = service.collectOrNot(collect);
            System.out.println(collect2);
            if (collect2 == null){
                return fail(500, "未追漫");
            }
            return success("已追漫");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }


    /**
     * 取消追漫
     * @param cartoonInfo
     * @param session
     * @return
     */
    @PostMapping("/deselectCollect")
    public ResponseVO deselectCollect(CartoonInfo cartoonInfo, HttpSession session){
        try {
            Collect collect = new Collect();
            User user = (User) session.getAttribute("user");
            collect.setCartoonInfo(cartoonInfo);
            collect.setUser(user);
            service.deselectCollect(collect);
            return success("已取消追漫");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }

    /**
     * 获取追漫列表
     * @param session
     * @return
     */
    @GetMapping("/listCollect")
    public ResponseVO listCollect(HttpSession session){
        try {
            User user = (User) session.getAttribute("user");

            return success(service.listCollect(user));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }

    /**
     * 阅读记录
     * @param cartoonInfo
     * @param record
     * @param session
     * @return
     */
    @PostMapping("/record")
    public ResponseVO record(CartoonInfo cartoonInfo, Record record, HttpSession session){
        try {
            User user = (User) session.getAttribute("user");
            if (user == null){
                return fail(500,"登录后可以保存记录哦");
            }
            record.setCartoonInfo(cartoonInfo);
            record.setUser(user);
            record.setJudge(user.getUserNumber() + cartoonInfo.getCartoonId());
            service.record(record);
            return success("记录成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }


    /**
     * 获取历史记录
     * @param session
     * @return
     */
    @GetMapping("/listRecord")
    public ResponseVO listRecord(HttpSession session){
        try {
            User user = (User) session.getAttribute("user");
            return success(service.listRecord(user));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }


    @GetMapping("/recordRead")
    public ResponseVO recordRead(HttpSession session, CartoonInfo cartoonInfo) {
        try {
            Record record = new Record();
            User user = (User) session.getAttribute("user");
            record.setUser(user);
            record.setCartoonInfo(cartoonInfo);
            Record recordNow = service.recordRead(record);
            if (recordNow == null) {
                return fail(404);
            }
            return success(recordNow);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }
    /*
    获取漫画的封面
     */
    @GetMapping("/cartoons")
    public ResponseVO<List<CartoonInfo>> listCartoon(HttpServletRequest request, Integer pageNum, Integer pageSize) {
        try {

            cartoonUrl = request.getSession().getServletContext().getRealPath("./") + "static\\img\\cartoon\\cartoon\\";
            List<CartoonInfo> list = service.listCartoon(pageNum, pageSize);
            return success(list);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }

    /*
    获取漫画的信息
     */

    @GetMapping("/cartoon")
    public ResponseVO getCartoonById(Integer cartoonId) {
        try {
            CartoonInfo cartoonInfo = service.getCartoonById(cartoonId);
            if (cartoonInfo == null) {
                return fail(500, "服务器异常");
            }

            return success(cartoonInfo);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }


    /**
     * 获取漫画集数
     * @param cartoonId
     * @return
     */
    @GetMapping("/serialize")
    public ResponseVO serialize(Integer cartoonId) {
        try {
            CartoonInfo cartoonInfo = service.getCartoonById(cartoonId);
            if (cartoonInfo == null) {
                return fail(500, "服务器异常");
            }

            List<String> list = getUrl(new File(cartoonUrl + cartoonInfo.getCartoonResource()));
            return success(list);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }


    /**
     * 获取漫画资源
     * @param cartoonId
     * @param serialize
     * @return
     */
    @GetMapping("/read")
    public ResponseVO read(Integer cartoonId, String serialize) {
        try {
            CartoonInfo cartoonInfo = service.getCartoonById(cartoonId);
            if (cartoonInfo == null) {
                return fail(500, "服务器异常");
            }
            List<String> list = getUrl(new File(cartoonUrl + cartoonInfo.getCartoonResource() + "\\" + serialize));
            List<String> listUrl = new ArrayList<>();
            for (String s : list) {
                s = cartoonInfo.getCartoonResource() + "/" + serialize + "/" + s;
                listUrl.add(s);
            }
            return success(listUrl);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return fail(500, "服务器异常");
        }
    }

    /**
     * 获取文件名
     * @param file
     * @return
     */
    private static List<String> getUrl(File file) {
        List<String> list = new ArrayList<>();
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                list.add(files[i].getName());
            }
            return list;
        } else {
            System.out.println("File is null");
            return null;
        }
    }


    /*
    浏览文件
     */

    private static List<String> isDirectory(File file) {

        List<String> listUrl = new ArrayList<>();
        if (file.exists()) {
            if (file.isFile()) {
                listUrl.add(file.getAbsolutePath());
                /*  输出结果
                 * file is ==>>D:\qrcodeFile\20190116\5c594aee7a3d4b99b234b21456d053c4.png
                 * */
            } else {
                //list获取的结果：[D:\qrcodeFile\20190116, D:\qrcodeFile\20190117]
                File[] list = file.listFiles();

                if (list.length == 0) {
                    System.out.println(file.getAbsolutePath() + " is null");
                } else {
                    for (int i = 0; i < list.length; i++) {
                        isDirectory(list[i]);
                    }
                }
            }

            return listUrl;
        } else {
            System.out.println("File is null");
            return listUrl;
        }

    }
}



