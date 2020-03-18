package test;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Author:zhouxd
 * @Date: 2019/9/12 16:32
 * @Description: 接口返回
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenericResponse<T> implements Serializable {
    private static final long serialVersionUID = -8262324610084881707L;

    /**
     * 成功：0；失败：1
     */
    private String code;
    /**
     * 返回结果代码
     */
    private String resultCode;
    /**
     * 失败原因
     */
    private String msg;

    /**
     * 错误异常
     */
    private String stackTrace;
    /**
     * 成功返回数据
     */
    private T data;

    /**
     * 成功代码
     */
    public static final String SUCCESS_CODE = "0";



    public GenericResponse(T data, String msg) {
        this.data = data;
        this.code = SUCCESS_CODE;
        this.msg = msg;
    }


}
