package com.pirvate.store.service.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  23:28
 * Description(说明)):
 *  密码不匹配
 */
public class PasswordNotMatchException extends ServiceException{
    public PasswordNotMatchException() {
        super();
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
