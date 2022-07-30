package com.pirvate.store.service.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  16:18
 * Description(说明)):
 *   业务层异常基类
 */
public class ServiceException extends RuntimeException{

    public ServiceException() {
        super();
    }

    /**
     * @param message  抛出异常信息
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * @param message  抛出异常信息
     * @param cause   抛出异常的对象
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause 抛出异常的对象
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
