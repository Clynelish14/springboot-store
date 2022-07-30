package com.pirvate.store.util;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/21  20:19
 * Description(说明)):
 *      响应数据封装类
 */
@Data
@NoArgsConstructor
@ToString
public class JsonResult<E> implements Serializable {
    private Integer state;  //状态码
    private String message;  //状态码的描述信息
    private E data;  //具体数据，用泛型表示，可能是任意类型的数据

    public JsonResult(Integer state) {
        this.state = state;
    }

    /* 获取异常属性 */
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
}
