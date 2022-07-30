package com.pirvate.store.controller.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/23  20:49
 * Description(说明)):
 *  文件为空的异常
 */
public class FileEmptyException extends FileUploadException{
    public FileEmptyException() {
        super();
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
