package cn.connext.toolback.entity;

import java.util.List;

/**
 *  查询用户列表
 */
public class ResultResponse {
    private Object result;
    private int totalCount;
    //是不是成功了
    private boolean successFlag;
    //如果有消息，返回失败的消息
    private String errorMessage;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
