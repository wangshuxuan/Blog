package ssm.blog.utils;

import java.io.Serializable;

/**
 * @author wangshuxuan
 * @date 2018/8/24 12:42
 * 用于向页面传递信息的类
 */

public class Result implements Serializable {

    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public Result(boolean success) {
        super();
        this.success = success;
    }


    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
