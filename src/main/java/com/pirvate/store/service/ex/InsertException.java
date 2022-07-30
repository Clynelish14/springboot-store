package com.pirvate.store.service.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  16:31
 * Description(说明)):
 *  数据插入时异常（数据库宕机...）
 */
public class InsertException extends ServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
