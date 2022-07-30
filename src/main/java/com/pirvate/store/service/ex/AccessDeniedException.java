package com.pirvate.store.service.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/26  17:44
 * Description(说明)):
 *  非法访问异常 用户访问的不是自己的收货信息
 */
public class AccessDeniedException extends ServiceException{
    public AccessDeniedException() {
        super();
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    protected AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
