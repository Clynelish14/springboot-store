package com.pirvate.store.controller.ex;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/23  20:51
 * Description(说明)):
 *  文件读写遗产
 */
public class FileUploadIOException extends FileUploadException{
    public FileUploadIOException() {
        super();
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
