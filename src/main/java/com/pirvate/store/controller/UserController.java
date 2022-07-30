package com.pirvate.store.controller;

import com.pirvate.store.controller.ex.*;
import com.pirvate.store.entity.User;
import com.pirvate.store.service.UserService;
import com.pirvate.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  20:32
 * Description(说明)):
 */

@RestController
@RequestMapping("/users")
public class UserController extends BaseController{

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *  注册账号
     *  不写method = RequestMethod.POST也行，ajax发来POST控制器会自己适应成post
     * @param user
     * @return
     */
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public JsonResult<Void> reg(User user) {
            userService.reg(user);
        return new JsonResult<>(OK);
    }

    /**
     *  登录控制器方法
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public JsonResult<User> login(User user, HttpSession session){
        User login = userService.login(user);
        session.setAttribute("uid",login.getUid());
        session.setAttribute("username",login.getUsername());

        return new JsonResult<>(OK,login);
    }

    /**
     * 修改页面
     * @param oldPassword
     * @param newPassword
     * @param session
     * @return
     */
    @RequestMapping("/changePassword")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        userService.changePassword(uid,oldPassword,newPassword);
        session.removeAttribute("uid");
        return new JsonResult<>(OK);
    }

    /**
     *  个人信息展示
     * @param session
     * @return
     */
    @RequestMapping("/getUserById")
    public JsonResult<User> getUserById(HttpSession session){
        User user = userService.getUserById(getUidFromSession(session));
        return new JsonResult<>(OK,user);
    }

    /**
     *  修改个人信息
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/changeInfo")
    public JsonResult<Void> changeInfo(HttpSession session,User user){
        user.setUid(getUidFromSession(session));
        userService.changeInfo(user);
        return new JsonResult<>(OK);
    }

    // 规定上传图片的类型
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }
    public static final int AVATAR_MAX_SIZE=10*1024*1024;

    @RequestMapping("/changeAvatar")
    public JsonResult<String> changeAvatar(HttpSession session,
                                         @RequestParam("file") MultipartFile file){
        //先判断异常
        if(file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }else if(file.getSize()>AVATAR_MAX_SIZE){
            throw new FileSizeException("图片大小超出限制");
        }
        //获取文件类型 和规定的类型集合比较
        String contentType = file.getContentType();
        if(!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("不支持该格式的文件");
        }
                               // 获取上下文路径             某个文件的绝对路径
                            // 没有视图模拟器的情况下不能使用，不然会路径会定在项目启动后tomcat的一个路径，关闭就会删除，每次开启项目就是新路径
//        String upload = session.getServletContext().getRealPath("static/upload");
        String upload = "E:\\ideaProject\\store\\src\\main\\resources\\static\\upload";
        File dir = new File(upload); // 设置上传路径
        if(!dir.exists()){
            dir.mkdir();   //如果路径不存在，就创建出来
        }
        //获取上传文件的名字
        String filename = file.getOriginalFilename();
        /* 为了防止相同名字的文件被覆盖，需要用UUID重命名文件  */
        //第一步 通过uuid 生成一个随机字符串 作为文件的新名字
        String newName = UUID.randomUUID().toString().toUpperCase();
        //第二步 拿到文件格式
        String suffix = filename.substring(filename.lastIndexOf("."));
        //第三步 合成
        String fileName = newName+suffix;
        try {
            file.transferTo(new File(dir,fileName));//上传
        } catch (IOException e) {
            throw new FileUploadIOException("文件读取出现错误");
        } catch (FileStateException e){
            throw new FileStateException("文件当前状态异常");
        }
        //执行
        User user = new User();
        user.setUid(getUidFromSession(session));
        user.setUsername(getUsernameFromSession(session));
//        String avatar= "/upload/" +fileName; //头像的相对路径
        String avatar= "http://localhost:8080/upload/"+fileName; //头像的相对路径

        user.setAvatar(avatar);
        userService.uploadAvatar(user);
        return new JsonResult<String>(OK,avatar);
    }
}
