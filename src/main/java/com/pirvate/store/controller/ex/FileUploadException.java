package com.pirvate.store.controller.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/23  20:48
 * Description(说明)):
 *   文件上传异常的父类
 */
public class FileUploadException extends RuntimeException{
    public FileUploadException() {
        super();
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
