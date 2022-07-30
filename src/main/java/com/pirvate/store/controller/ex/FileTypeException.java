package com.pirvate.store.controller.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/23  20:50
 * Description(说明)):
 *  文件类型异常
 */
public class FileTypeException extends FileUploadException{
    public FileTypeException() {
        super();
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
