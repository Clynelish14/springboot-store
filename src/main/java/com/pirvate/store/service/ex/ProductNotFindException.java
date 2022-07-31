package com.pirvate.store.service.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/31  8:59
 * Description(说明)):
 */
public class ProductNotFindException extends ServiceException{
    public ProductNotFindException() {
        super();
    }

    public ProductNotFindException(String message) {
        super(message);
    }

    public ProductNotFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFindException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
