package com.pirvate.store.service.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  16:29
 * Description(说明)):
 *          用户名被占用异常
 */
public class UserNameDuplicatedException extends ServiceException{
    public UserNameDuplicatedException() {
        super();
    }

    public UserNameDuplicatedException(String message) {
        super(message);
    }

    public UserNameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected UserNameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
