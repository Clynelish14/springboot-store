package com.pirvate.store.controller.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/23  21:34
 * Description(说明)):
 *  文件状态异常
 */
public class FileStateException extends FileUploadException{
    public FileStateException() {
        super();
    }

    public FileStateException(String message) {
        super(message);
    }

    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
