package com.pirvate.store.controller;

import com.pirvate.store.controller.ex.*;
import com.pirvate.store.entity.ProductExample;
import com.pirvate.store.service.ProductService;
import com.pirvate.store.service.ex.*;
import com.pirvate.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  21:13
 * Description(说明)):
 *  控制层处理异常的基类
 */
public class BaseController {
    /* 处理成功状态码 */
    public static final Integer OK=21400;

    @ExceptionHandler({ServiceException.class,FileUploadException.class})// 用于统一处理抛出的异常 【括号里指定要统一处理的类型】
    public JsonResult<Void> handlerException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        /*   e 是否属于    */
        if(e instanceof UserNameDuplicatedException){
            result.setState(17900);
            result.setMessage("用户名被占用");
        }else if(e instanceof UserNotFoundException){
            result.setState(17901);
            result.setMessage("用户名不存在");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(17902);
            result.setMessage("密码错误");
        }else if(e instanceof UpdateException){
            result.setState(17903);
            result.setMessage("更新数据时发生未知错误。");
        }else if(e instanceof InsertException){
            result.setState(17904);
            result.setMessage("注册时发生未知错误。");
        }else if(e instanceof FileEmptyException){
            result.setState(19650);
            result.setMessage("文件为空。");
        }else if(e instanceof FileStateException){
            result.setState(19651);
            result.setMessage("文件状态异常。");
        }else if(e instanceof FileSizeException){
            result.setState(19652);
            result.setMessage("文件大小超出范围。");
        }else if(e instanceof FileTypeException){
            result.setState(19653);
            result.setMessage("文件类型异常。");
        }else if(e instanceof FileUploadIOException){
            result.setState(19654);
            result.setMessage("文件读写异常。");
        }else if(e instanceof AddressCountLimitException){
            result.setState(2200);
            result.setMessage("新增收货地址失败");
        }else if(e instanceof AccessDeniedException){
            result.setState(2201);
            result.setMessage("非法访问，该收货地址不属于当前用户");
        }else if(e instanceof AddressNotFoundException){
            result.setState(2202);
            result.setMessage("该收货地址不存在");
        }else if(e instanceof DeleteException){
            result.setState(2203);
            result.setMessage("删除数据产生未知错误");
        }else if(e instanceof ProductNotFindException){
            result.setState(2204);
            result.setMessage("没找到该商品");
        }



        return result;
    }

    /* 从session中获取uid */
    protected final Integer getUidFromSession(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        return uid;
    }
    /* 从session中获取Username */
    protected final String getUsernameFromSession(HttpSession session){
        String username = session.getAttribute("username").toString();
        return username;
    }
}
