package com.pirvate.store.service.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/28  18:19
 * Description(说明)):
 * 删除失败异常
 */
public class DeleteException extends ServiceException{
    public DeleteException() {
        super();
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    protected DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
